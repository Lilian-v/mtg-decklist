package fr.livar.mtg.mtgdecklist.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.livar.mtg.mtgdecklist.persistence.model.Card;
import fr.livar.mtg.mtgdecklist.persistence.model.CardDeckAssocRepository;
import fr.livar.mtg.mtgdecklist.persistence.model.CardRepository;
import fr.livar.mtg.mtgdecklist.persistence.model.Symbol;
import fr.livar.mtg.mtgdecklist.persistence.model.SymbolRepository;
import fr.livar.mtg.mtgdecklist.persistence.model.UniqueCard;
import fr.livar.mtg.mtgdecklist.persistence.model.UniqueCardRepository;
import fr.livar.mtg.mtgdecklist.scryfall.api.ScryfallApiService;
import fr.livar.mtg.mtgdecklist.scryfall.model.card.AllPart;
import fr.livar.mtg.mtgdecklist.scryfall.model.card.ScryfallCard;
import fr.livar.mtg.mtgdecklist.scryfall.model.symbol.ScryfallSymbol;

@RestController
public class ScryfallSynchronisationController {
	private static final Logger logger = LoggerFactory.getLogger(ScryfallSynchronisationController.class);
	
	private SymbolRepository symbolRepository;
	private UniqueCardRepository uniqueCardRepository;
	private CardRepository cardRepository;
	private CardDeckAssocRepository cardDeckAssocRepository;
	
	@Autowired
	private ScryfallApiService scryfallApiService;
	
	private boolean isRunning = false;
	
	public ScryfallSynchronisationController(SymbolRepository symbolRepository) {
		this.symbolRepository = symbolRepository;
	}
	
	@GetMapping("/scryfallsynchro/symbols")
	public String synchroniseAllSymbols() {
		if (isRunning) {
			return "A synchronisation is already running";
		}
		
		try {
			isRunning = true;
			
			List<ScryfallSymbol> scryfallSymbols = scryfallApiService.getAllSymbols();
			List<Symbol> symbols = scryfallSymbols.stream().map(scryfallSymbol -> new Symbol(scryfallSymbol.symbol, scryfallSymbol.svgUri, scryfallSymbol.english))
				.collect(Collectors.toList());
			
			symbolRepository.saveAllAndFlush(symbols);
			
			String resMessage = "" + symbols.size() + " symbols synchronised";
			logger.info(resMessage);
			return resMessage;
		} finally {
			isRunning = false;
		}
	}
	
	@GetMapping("/scryfallsynchro/cards")
	public String synchroniseAllcards() {
		return synchroniseAllCards("all_cards");
	}
	
	@GetMapping("/scryfallsynchro/cards/{bulkId}")
	public String synchroniseAllCards(@PathVariable String bulkId) {
		if (isRunning) {
			return "A synchronisation is already running";
		}
		
		try {
			isRunning = true;
			List<ScryfallCard> scryfallCards = scryfallApiService.getAllCards(bulkId);
			
			Map<String, UniqueCard> uniqueCards = new HashMap<String, UniqueCard>();
			List<Card> cards = new ArrayList<Card>();
			//List<String> relatedCards = new HashSet<String>();
			for (ScryfallCard scryfallCard : scryfallCards) {
				String oracleId = scryfallCard.oracleId;
				UniqueCard uniqueCard = uniqueCards.get(oracleId);
				if (uniqueCard == null && StringUtils.isNotEmpty(oracleId)) {
					String commanderLegality = null;
					if (scryfallCard.legalities != null) {
						commanderLegality = scryfallCard.legalities.commander;
					}
					uniqueCard = new UniqueCard(oracleId, scryfallCard.name, scryfallCard.layout, scryfallCard.typeLine, scryfallCard.oracleText, 
							scryfallCard.manaCost, scryfallCard.cmc, scryfallCard.colors, scryfallCard.colorIdentity, scryfallCard.keywords, 
							commanderLegality, scryfallCard.power, scryfallCard.toughness, scryfallCard.defense, 
							scryfallCard.producedMana, scryfallCard.loyalty);
					uniqueCards.put(oracleId, uniqueCard);
				}
				
				String imageUriNormal = null;
				if (scryfallCard.imageUris != null) {
					imageUriNormal = scryfallCard.imageUris.normal;
				}
				Card card = new Card(scryfallCard.id, uniqueCard, scryfallCard.lang, imageUriNormal, scryfallCard.printedName,
						scryfallCard.printedText, scryfallCard.printedTypeLine, scryfallCard.flavorName, scryfallCard.flavorText);
				cards.add(card);
				
				if (scryfallCard.allParts != null) {
					for (AllPart relatedCard : scryfallCard.allParts) {
						
					}
				}
			}
			
			String resMessage = ""  + cards.size() + " cartes synchronisées (" + uniqueCards.size() + " cartes uniques)";
			logger.info(resMessage);
			return resMessage;
		} finally {
			isRunning = false;
		}
	}
	
}
