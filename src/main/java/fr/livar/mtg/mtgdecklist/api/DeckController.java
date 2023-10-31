package fr.livar.mtg.mtgdecklist.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.livar.mtg.mtgdecklist.persistence.model.CardDeckAssoc;
import fr.livar.mtg.mtgdecklist.persistence.model.CardDeckAssocRepository;
import fr.livar.mtg.mtgdecklist.persistence.model.Deck;
import fr.livar.mtg.mtgdecklist.persistence.model.DeckRepository;

@RestController
public class DeckController {
	private DeckRepository deckRepository;
	private CardDeckAssocRepository cardDeckAssocRepository;
	
	public DeckController(DeckRepository deckRepository, CardDeckAssocRepository cardDeckAssocRepository) {
		this.deckRepository = deckRepository;
		this.cardDeckAssocRepository = cardDeckAssocRepository;
	}
	
	@PostMapping("/deck")
	public Deck createDeck() {
		return null;
	}
	@GetMapping("/deck/{deckId}")
	public Deck getDeck(@PathVariable String deckId) {
		return null;
	}
	@PutMapping("/deck/{deckId}")
	public Deck updateDeck(@PathVariable String deckId) {
		return null;
	}
	@DeleteMapping("/deck/{deckId}")
	public void deleteDeck(@PathVariable String deckId) {
		
	}
	
	@GetMapping("/deck/{deckId}/cards")
	public List<CardDeckAssoc> getDeckCards(@PathVariable String deckId) {
		return null;
	}
	@PostMapping("/deck/{deckId}/card")
	public void addDeckCard(@PathVariable String deckId) {
		return;
	}
	@PutMapping("/deck/{deckId}/card")
	public void updateDeckCard(@PathVariable String deckId) {
		return;
	}
	@DeleteMapping("/deck/{deckId}/card")
	public void deleteDeckCard(@PathVariable String deckId) {
		
	}
	
}
