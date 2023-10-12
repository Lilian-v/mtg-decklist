
package fr.livar.mtg.mtgdecklist.scryfall.model.symbol;

import java.util.LinkedHashMap;
import java.util.List;
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
    "object",
    "symbol",
    "svg_uri",
    "loose_variant",
    "english",
    "transposable",
    "represents_mana",
    "appears_in_mana_costs",
    "mana_value",
    "cmc",
    "funny",
    "colors",
    "gatherer_alternates"
})
@Generated("jsonschema2pojo")
public class ScryfallSymbol {

    @JsonProperty("object")
    public String object;
    @JsonProperty("symbol")
    public String symbol;
    @JsonProperty("svg_uri")
    public String svgUri;
    @JsonProperty("loose_variant")
    public String looseVariant;
    @JsonProperty("english")
    public String english;
    @JsonProperty("transposable")
    public Boolean transposable;
    @JsonProperty("represents_mana")
    public Boolean representsMana;
    @JsonProperty("appears_in_mana_costs")
    public Boolean appearsInManaCosts;
    @JsonProperty("mana_value")
    public Float manaValue;
    @JsonProperty("cmc")
    public Float cmc;
    @JsonProperty("funny")
    public Boolean funny;
    @JsonProperty("colors")
    public List<String> colors;
    @JsonProperty("gatherer_alternates")
    public Object gathererAlternates;
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
