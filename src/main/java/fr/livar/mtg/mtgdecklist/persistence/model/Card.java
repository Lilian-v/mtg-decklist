package fr.livar.mtg.mtgdecklist.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	@Id private String cardId;
	@ManyToOne UniqueCard oracleCardId;
	private String langCode;
	private String imageNormalSizeUrl;
	
	private String printedName;
	private String printedText;
	private String printedTypeLine;
	private String flavorName;
	private String flavorText;
	
	public Card(String cardId, UniqueCard oracleCardId, String langCode, String imageNormalSizeUrl, String printedName,
			String printedText, String printedTypeLine, String flavorName, String flavorText) {
		this.cardId = cardId;
		this.oracleCardId = oracleCardId;
		this.langCode = langCode;
		this.imageNormalSizeUrl = imageNormalSizeUrl;
		this.printedName = printedName;
		this.printedText = printedText;
		this.printedTypeLine = printedTypeLine;
		this.flavorName = flavorName;
		this.flavorText = flavorText;
	}
	
	public String getCardId() {
		return cardId;
	}
	public UniqueCard getOracleCardId() {
		return oracleCardId;
	}
	public String getLangCode() {
		return langCode;
	}
	public String getImageNormalSizeUrl() {
		return imageNormalSizeUrl;
	}
	public String getPrintedName() {
		return printedName;
	}
	public String getPrintedText() {
		return printedText;
	}
	public String getPrintedTypeLine() {
		return printedTypeLine;
	}
	public String getFlavorName() {
		return flavorName;
	}
	public String getFlavorText() {
		return flavorText;
	}
	
	
}
