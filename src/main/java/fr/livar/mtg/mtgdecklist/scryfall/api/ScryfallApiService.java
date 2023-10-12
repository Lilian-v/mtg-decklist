package fr.livar.mtg.mtgdecklist.scryfall.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.livar.mtg.mtgdecklist.scryfall.model.bulk.ScryfallBulk;
import fr.livar.mtg.mtgdecklist.scryfall.model.bulk.ScryfallBulksWrapper;
import fr.livar.mtg.mtgdecklist.scryfall.model.card.ScryfallCard;
import fr.livar.mtg.mtgdecklist.scryfall.model.symbol.ScryfallSymbol;
import fr.livar.mtg.mtgdecklist.scryfall.model.symbol.ScryfallSymbolWrapper;
import jakarta.annotation.PostConstruct;

@Service
public class ScryfallApiService {
	private static final Logger logger = LoggerFactory.getLogger(ScryfallApiService.class);
	
	@Value("${mtg-decklist.scryfall.api.url}")
	private String apiBaseUrl;
	
	private RestTemplate restTemplate;
	
	
	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}
	
	public List<ScryfallSymbol> getAllSymbols() {
		ResponseEntity<ScryfallSymbolWrapper> responseSymbols = restTemplate.getForEntity(apiBaseUrl + "symbology", ScryfallSymbolWrapper.class);
		if (!HttpStatus.OK.equals(responseSymbols.getStatusCode())) {
			throw new IllegalStateException("Call to /symbol Scryfall API returning a non OK code : " + responseSymbols.getStatusCode().value());
		}
		
		List<ScryfallSymbol> result = responseSymbols.getBody().data;
		logger.debug(result.size() + " symbols found on Scryfall API");
		return result;
	}
	
	public List<ScryfallCard> getAllCards(String bulkId) {
		ResponseEntity<ScryfallBulksWrapper> responseBulks = restTemplate.getForEntity(apiBaseUrl + "bulk-data", ScryfallBulksWrapper.class);
		if (!HttpStatus.OK.equals(responseBulks.getStatusCode())) {
			throw new IllegalStateException("Call to /bulk-data Scryfall API returning a non OK code : " + responseBulks.getStatusCode().value());
		}
		
		List<ScryfallBulk> bulkResult = responseBulks.getBody().data;
		logger.debug(bulkResult.size() + " bulks found on Scryfall API");
		
		Optional<ScryfallBulk> bulk = bulkResult.stream().filter(bulkObj -> bulkId.equals(bulkObj.type)).findAny();
		if (bulk.isEmpty()) {
			throw new IllegalStateException("Bulk import not found with ID : " + bulkId);
		}
		
		
		ResponseEntity<List<ScryfallCard>> responseAllCards = restTemplate.exchange(bulk.get().downloadUri, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<ScryfallCard>>() {});
		if (!HttpStatus.OK.equals(responseAllCards.getStatusCode())) {
			throw new IllegalStateException("Call to " + bulk.get().downloadUri + " returning a non OK code : " + responseAllCards.getStatusCode().value());
		}
		List<ScryfallCard> allCards = responseAllCards.getBody();
		logger.debug(allCards.size() + " cards found on Scryfall API");
		return allCards;
	}

}
