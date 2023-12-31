package fr.livar.mtg.mtgdecklist.persistence.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(CardDeckAssoc.class) 
@Table(name = "card_deck_assoc")
public class CardDeckAssoc {
	@Id @ManyToOne private Deck deckId;
	@Id @ManyToOne private Card cardId;
	private int number;
	private boolean isCommander;
	
	public CardDeckAssoc() {}
	public CardDeckAssoc(Deck deckId, Card cardId, int number, boolean isCommander) {
		this.deckId = deckId;
		this.cardId = cardId;
		this.number = number;
		this.isCommander = isCommander;
	}

	public Deck getDeckId() {
		return deckId;
	}

	public Card getCardId() {
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cardId, deckId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardDeckAssoc other = (CardDeckAssoc) obj;
		return Objects.equals(cardId, other.cardId) && Objects.equals(deckId, other.deckId);
	}
}
