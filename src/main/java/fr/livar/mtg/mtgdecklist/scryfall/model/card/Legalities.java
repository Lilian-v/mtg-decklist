
package fr.livar.mtg.mtgdecklist.scryfall.model.card;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "standard",
    "future",
    "historic",
    "gladiator",
    "pioneer",
    "explorer",
    "modern",
    "legacy",
    "pauper",
    "vintage",
    "penny",
    "commander",
    "oathbreaker",
    "brawl",
    "historicbrawl",
    "alchemy",
    "paupercommander",
    "duel",
    "oldschool",
    "premodern",
    "predh"
})
@Generated("jsonschema2pojo")
public class Legalities {

    @JsonProperty("standard")
    public String standard;
    @JsonProperty("future")
    public String future;
    @JsonProperty("historic")
    public String historic;
    @JsonProperty("gladiator")
    public String gladiator;
    @JsonProperty("pioneer")
    public String pioneer;
    @JsonProperty("explorer")
    public String explorer;
    @JsonProperty("modern")
    public String modern;
    @JsonProperty("legacy")
    public String legacy;
    @JsonProperty("pauper")
    public String pauper;
    @JsonProperty("vintage")
    public String vintage;
    @JsonProperty("penny")
    public String penny;
    @JsonProperty("commander")
    public String commander;
    @JsonProperty("oathbreaker")
    public String oathbreaker;
    @JsonProperty("brawl")
    public String brawl;
    @JsonProperty("historicbrawl")
    public String historicbrawl;
    @JsonProperty("alchemy")
    public String alchemy;
    @JsonProperty("paupercommander")
    public String paupercommander;
    @JsonProperty("duel")
    public String duel;
    @JsonProperty("oldschool")
    public String oldschool;
    @JsonProperty("premodern")
    public String premodern;
    @JsonProperty("predh")
    public String predh;
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
