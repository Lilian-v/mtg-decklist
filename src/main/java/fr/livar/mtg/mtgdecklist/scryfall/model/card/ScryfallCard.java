
package fr.livar.mtg.mtgdecklist.scryfall.model.card;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Generated("jsonschema2pojo")
public class ScryfallCard {

    @JsonProperty("id")
    public String id;
    @JsonProperty("oracle_id")
    public String oracleId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("lang")
    public String lang;
    @JsonProperty("layout")
    public String layout;
    @JsonProperty("image_uris")
    public ImageUris imageUris;
    @JsonProperty("mana_cost")
    public String manaCost;
    @JsonProperty("cmc")
    public Float cmc;
    @JsonProperty("type_line")
    public String typeLine;
    @JsonProperty("oracle_text")
    public String oracleText;
    @JsonProperty("power")
    public String power;
    @JsonProperty("toughness")
    public String toughness;
    @JsonProperty("defense")
    public String defense;
    @JsonProperty("loyalty")
    public String loyalty;
    @JsonProperty("colors")
    public List<String> colors;
    @JsonProperty("color_identity")
    public List<String> colorIdentity;
    @JsonProperty("produced_mana")
    public List<String> producedMana;
    @JsonProperty("keywords")
    public List<String> keywords;
    @JsonProperty("legalities")
    public Legalities legalities;
    @JsonProperty("flavor_name")
    public String flavorName;
    @JsonProperty("flavor_text")
    public String flavorText;
    @JsonProperty("printed_name")
    public String printedName;
    @JsonProperty("printed_text")
    public String printedText;
    @JsonProperty("printed_type_line")
    public String printedTypeLine;
    @JsonProperty("all_parts")
    public List<AllPart> allParts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
