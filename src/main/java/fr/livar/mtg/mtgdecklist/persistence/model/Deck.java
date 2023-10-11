package fr.livar.mtg.mtgdecklist.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deck")
public class Deck {
	@Id @GeneratedValue private int deckId;
	private int userId;
	private String deckName;
	
	public Deck(int userId, String deckName) {
		this.userId = userId;
		this.deckName = deckName;
	}

	public int getDeckId() {
		return deckId;
	}

	public int getUserId() {
		return userId;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	
	

}
