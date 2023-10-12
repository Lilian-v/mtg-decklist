
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
    "gatherer",
    "tcgplayer_infinite_articles",
    "tcgplayer_infinite_decks",
    "edhrec"
})
@Generated("jsonschema2pojo")
public class RelatedUris {

    @JsonProperty("gatherer")
    public String gatherer;
    @JsonProperty("tcgplayer_infinite_articles")
    public String tcgplayerInfiniteArticles;
    @JsonProperty("tcgplayer_infinite_decks")
    public String tcgplayerInfiniteDecks;
    @JsonProperty("edhrec")
    public String edhrec;
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
