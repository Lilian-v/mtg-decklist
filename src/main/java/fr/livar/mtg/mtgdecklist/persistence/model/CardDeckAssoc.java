package fr.livar.mtg.mtgdecklist.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(CardDeckAssoc.class) 
@Table(name = "card_deck_assoc")
public class CardDeckAssoc {
	@Id private int deckId;
	@Id private int cardId;
	private int number;
	private boolean isCommander;
	
	public CardDeckAssoc(int deckId, int cardId, int number, boolean isCommander) {
		this.deckId = deckId;
		this.cardId = cardId;
		this.number = number;
		this.isCommander = isCommander;
	}

	public int getDeckId() {
		return deckId;
	}

	public int getCardId() {
		return cardId;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isCommander() {
		return isCommander;
	}

	public void setCommander(boolean isCommander) {
		this.isCommander = isCommander;
	}

}
