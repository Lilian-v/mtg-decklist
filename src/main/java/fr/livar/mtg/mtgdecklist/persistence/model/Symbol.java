package fr.livar.mtg.mtgdecklist.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card_symbol")
public class Symbol {
	@Id private String symbol;
	private String svgUrl;
	private String englishText;
	
	public Symbol() {}
	public Symbol(String symbol, String svgUrl, String englishText) {
		super();
		this.symbol = symbol;
		this.svgUrl = svgUrl;
		this.englishText = englishText;
	}

	public String getSymbol() {
		return symbol;
	}
	public String getSvgUrl() {
		return svgUrl;
	}
	public String getEnglishText() {
		return englishText;
	}
	
}
