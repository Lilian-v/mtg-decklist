package fr.livar.mtg.mtgdecklist.persistence.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unique_card")
public class UniqueCard {
	@Id private String oracleCardId;
	private String name;
	private String layout;
	private String typeLine;
	private String oracleText;
	private String manaCost;
	private Float convertedManaCost;
	private List<String> colors;
	private List<String> colorIdentity;
	private List<String> keywords;
	private String commanderLegality;
	
	private String creaturePower;
	private String creatureToughness;
	private String battleDefense;
	private List<String> producedManaColors;
	private String planeswalkerLoyalty;
	
	public UniqueCard(String oracleCardId, String name, String layout, String typeLine, String oracleText, String manaCost,
			Float convertedManaCost, List<String> colors, List<String> colorIdentity, List<String> keywords, String commanderLegality,
			String creaturePower, String creatureToughness, String battleDefense, List<String> producedManaColors, String planeswalkerLoyalty) {
		this.oracleCardId = oracleCardId;
		this.name = name;
		this.layout = layout;
		this.typeLine = typeLine;
		this.oracleText = oracleText;
		this.manaCost = manaCost;
		this.convertedManaCost = convertedManaCost;
		this.colors = colors;
		this.colorIdentity = colorIdentity;
		this.keywords = keywords;
		this.commanderLegality = commanderLegality;
		this.creaturePower = creaturePower;
		this.creatureToughness = creatureToughness;
		this.battleDefense = battleDefense;
		this.producedManaColors = producedManaColors;
		this.planeswalkerLoyalty = planeswalkerLoyalty;
	}
	
	public String getOracleCardId() {
		return oracleCardId;
	}
	public String getName() {
		return name;
	}
	public String getLayout() {
		return layout;
	}
	public String getTypeLine() {
		return typeLine;
	}
	public String getOracleText() {
		return oracleText;
	}
	public String getManaCost() {
		return manaCost;
	}
	public Float getConvertedManaCost() {
		return convertedManaCost;
	}
	public List<String> getColors() {
		return colors;
	}
	public List<String> getColorIdentity() {
		return colorIdentity;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public String getCommanderLegality() {
		return commanderLegality;
	}
	public String getCreaturePower() {
		return creaturePower;
	}
	public String getCreatureToughness() {
		return creatureToughness;
	}
	public String getBattleDefense() {
		return battleDefense;
	}
	public List<String> getProducedManaColors() {
		return producedManaColors;
	}
	public String getPlaneswalkerLoyalty() {
		return planeswalkerLoyalty;
	}
}
