package fr.livar.mtg.mtgdecklist.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.livar.mtg.mtgdecklist.persistence.model.Card;
import fr.livar.mtg.mtgdecklist.persistence.model.CardRepository;
import fr.livar.mtg.mtgdecklist.persistence.model.RelatedCard;
import fr.livar.mtg.mtgdecklist.persistence.model.RelatedCardRepository;
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
	private RelatedCardRepository relatedCardRepository;
	
	@Autowired
	private ScryfallApiService scryfallApiService;
	
	@Value("${mtg-decklist.scryfall.api.card.relatedCards.relationTypesToExclude}")
	private List<String> EXCLUDED_RELATION_TYPES;
	
	private boolean isRunning = false;
	
	public ScryfallSynchronisationController(SymbolRepository symbolRepository, UniqueCardRepository uniqueCardRepository, 
			CardRepository cardRepository, RelatedCardRepository relatedCardRepository) {
		this.symbolRepository = symbolRepository;
		this.uniqueCardRepository = uniqueCardRepository;
		this.cardRepository = cardRepository;
		this.relatedCardRepository = relatedCardRepository;
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
			
			//Appel API pour récupérer les données
			logger.info("Starting API call to get cards to synchronise");
			List<ScryfallCard> scryfallCards = scryfallApiService.getAllCards(bulkId);
			logger.info(scryfallCards.size() + " cards to synchronise");
			
			// Parsing de la réponse et conversion en objets que l'on peut persister
			Map<String, UniqueCard> uniqueCards = new HashMap<String, UniqueCard>();
			Map<String, Card> cards = new HashMap<String, Card>();
			List<TempRelatedCard> tempRelatedCards = new ArrayList<TempRelatedCard>();
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
				cards.put(card.getCardId(), card);
				
				if (scryfallCard.allParts != null) {
					for (AllPart scryfallRelatedCard : scryfallCard.allParts) {
						if (!EXCLUDED_RELATION_TYPES.contains(scryfallRelatedCard.component)) {
							tempRelatedCards.add(new TempRelatedCard(card, scryfallRelatedCard.id, scryfallRelatedCard.component));
						}
					}
				}
			}
			
			// Persistance des éléments
			logger.info(uniqueCards.size() + " unique cards to save");
			uniqueCardRepository.saveAllAndFlush(uniqueCards.values());
			logger.info(cards.size() + " cards to save");
			cardRepository.saveAllAndFlush(cards.values());
			List<RelatedCard> finalRelatedCards = new ArrayList<RelatedCard>();
			List<TempRelatedCard> missingRelatedCards = new ArrayList<TempRelatedCard>();
			for (TempRelatedCard tempRelated : tempRelatedCards) {
				// Récupération dans la map si carte synchro à l'instant, sinon recherche en base de données
				Optional<Card> targetCard = cards.containsKey(tempRelated.getTargetCardId()) ? 
						Optional.of(cards.get(tempRelated.getTargetCardId())) :
						cardRepository.findById(tempRelated.getTargetCardId());
				if (targetCard.isPresent()) {
					finalRelatedCards.add(new RelatedCard(tempRelated.getSourceCard(), targetCard.get(), tempRelated.getRelationType()));
				}
				else {
					missingRelatedCards.add(tempRelated);
				}
			}
			if (missingRelatedCards.size() > 0) {
				logger.warn(missingRelatedCards.size() + " related cards missing in database : ");
				logger.warn(missingRelatedCards.stream().map(rlCard -> rlCard.getTargetCardId()).collect(Collectors.joining(", ")));
			}
			logger.info(finalRelatedCards.size() + " related cards to save");
			relatedCardRepository.saveAllAndFlush(finalRelatedCards);
			
			String resMessage = ""  + cards.size() + " cartes synchronisées (" + uniqueCards.size() + " cartes uniques)";
			logger.info(resMessage);
			return resMessage;
		} finally {
			isRunning = false;
		}
	}
	
	private class TempRelatedCard {
		private Card sourceCard;
		private String targetCardId;
		private String relationType;
		
		public TempRelatedCard(Card sourceCard, String targetCardId, String relationType) {
			this.sourceCard = sourceCard;
			this.targetCardId = targetCardId;
			this.relationType = relationType;
		}
		
		public Card getSourceCard() {
			return sourceCard;
		}
		public String getTargetCardId() {
			return targetCardId;
		}
		public String getRelationType() {
			return relationType;
		}
	}
	
}
