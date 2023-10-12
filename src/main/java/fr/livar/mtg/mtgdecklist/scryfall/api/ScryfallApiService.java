package fr.livar.mtg.mtgdecklist.scryfall.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
			throw new IllegalStateException("Call to Scryfall API returning a non OK code : " + responseSymbols.getStatusCode().value());
		}
		
		List<ScryfallSymbol> result = responseSymbols.getBody().data;
		logger.debug(result.size() + " symbols found on Scryfall API");
		return result;
	}
	

}
