
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
    "small",
    "normal",
    "large",
    "png",
    "art_crop",
    "border_crop"
})
@Generated("jsonschema2pojo")
public class ImageUris {

    @JsonProperty("small")
    public String small;
    @JsonProperty("normal")
    public String normal;
    @JsonProperty("large")
    public String large;
    @JsonProperty("png")
    public String png;
    @JsonProperty("art_crop")
    public String artCrop;
    @JsonProperty("border_crop")
    public String borderCrop;
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
