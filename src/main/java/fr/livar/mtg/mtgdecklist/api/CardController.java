package fr.livar.mtg.mtgdecklist.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.livar.mtg.mtgdecklist.persistence.model.Card;
import fr.livar.mtg.mtgdecklist.persistence.model.CardRepository;

@RestController
public class CardController {
	private CardRepository cardRepository;
	
	public CardController(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	@GetMapping("/card/{cardId}")
	Card getById(@PathVariable String cardId) {
		return cardRepository.findById(cardId).orElseThrow(() -> 
				new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found, id : " + cardId));
	}
	
}
