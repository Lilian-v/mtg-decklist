package fr.livar.mtg.mtgdecklist.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	@Id private int cardId;
	private String cardName;
	private String imageUrl;
	
	public Card(int cardId, String cardName, String imageUrl) {
		this.cardId = cardId;
		this.cardName = cardName;
		this.imageUrl = imageUrl;
	}

	public int getCardId() {
		return cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	
}
