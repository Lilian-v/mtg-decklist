
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
    "usd",
    "usd_foil",
    "usd_etched",
    "eur",
    "eur_foil",
    "tix"
})
@Generated("jsonschema2pojo")
public class Prices {

    @JsonProperty("usd")
    public Object usd;
    @JsonProperty("usd_foil")
    public Object usdFoil;
    @JsonProperty("usd_etched")
    public Object usdEtched;
    @JsonProperty("eur")
    public Object eur;
    @JsonProperty("eur_foil")
    public Object eurFoil;
    @JsonProperty("tix")
    public String tix;
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
