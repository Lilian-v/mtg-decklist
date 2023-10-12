
package fr.livar.mtg.mtgdecklist.scryfall.model.card;

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
    "id",
    "oracle_id",
    "multiverse_ids",
    "mtgo_id",
    "mtgo_foil_id",
    "name",
    "lang",
    "released_at",
    "uri",
    "scryfall_uri",
    "layout",
    "highres_image",
    "image_status",
    "image_uris",
    "mana_cost",
    "cmc",
    "type_line",
    "oracle_text",
    "power",
    "toughness",
    "colors",
    "color_identity",
    "keywords",
    "legalities",
    "games",
    "reserved",
    "foil",
    "nonfoil",
    "finishes",
    "oversized",
    "promo",
    "reprint",
    "variation",
    "set_id",
    "set",
    "set_name",
    "set_type",
    "set_uri",
    "set_search_uri",
    "scryfall_set_uri",
    "rulings_uri",
    "prints_search_uri",
    "collector_number",
    "digital",
    "rarity",
    "flavor_text",
    "card_back_id",
    "artist",
    "artist_ids",
    "illustration_id",
    "border_color",
    "frame",
    "full_art",
    "textless",
    "booster",
    "story_spotlight",
    "edhrec_rank",
    "penny_rank",
    "prices",
    "related_uris",
    "purchase_uris"
})
@Generated("jsonschema2pojo")
public class ScryfallCard {

    @JsonProperty("object")
    public String object;
    @JsonProperty("id")
    public String id;
    @JsonProperty("oracle_id")
    public String oracleId;
    @JsonProperty("multiverse_ids")
    public List<Integer> multiverseIds;
    @JsonProperty("mtgo_id")
    public Integer mtgoId;
    @JsonProperty("mtgo_foil_id")
    public Integer mtgoFoilId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("lang")
    public String lang;
    @JsonProperty("released_at")
    public String releasedAt;
    @JsonProperty("uri")
    public String uri;
    @JsonProperty("scryfall_uri")
    public String scryfallUri;
    @JsonProperty("layout")
    public String layout;
    @JsonProperty("highres_image")
    public Boolean highresImage;
    @JsonProperty("image_status")
    public String imageStatus;
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
    @JsonProperty("colors")
    public List<String> colors;
    @JsonProperty("color_identity")
    public List<String> colorIdentity;
    @JsonProperty("keywords")
    public List<Object> keywords;
    @JsonProperty("legalities")
    public Legalities legalities;
    @JsonProperty("games")
    public List<String> games;
    @JsonProperty("reserved")
    public Boolean reserved;
    @JsonProperty("foil")
    public Boolean foil;
    @JsonProperty("nonfoil")
    public Boolean nonfoil;
    @JsonProperty("finishes")
    public List<String> finishes;
    @JsonProperty("oversized")
    public Boolean oversized;
    @JsonProperty("promo")
    public Boolean promo;
    @JsonProperty("reprint")
    public Boolean reprint;
    @JsonProperty("variation")
    public Boolean variation;
    @JsonProperty("set_id")
    public String setId;
    @JsonProperty("set")
    public String set;
    @JsonProperty("set_name")
    public String setName;
    @JsonProperty("set_type")
    public String setType;
    @JsonProperty("set_uri")
    public String setUri;
    @JsonProperty("set_search_uri")
    public String setSearchUri;
    @JsonProperty("scryfall_set_uri")
    public String scryfallSetUri;
    @JsonProperty("rulings_uri")
    public String rulingsUri;
    @JsonProperty("prints_search_uri")
    public String printsSearchUri;
    @JsonProperty("collector_number")
    public String collectorNumber;
    @JsonProperty("digital")
    public Boolean digital;
    @JsonProperty("rarity")
    public String rarity;
    @JsonProperty("flavor_text")
    public String flavorText;
    @JsonProperty("card_back_id")
    public String cardBackId;
    @JsonProperty("artist")
    public String artist;
    @JsonProperty("artist_ids")
    public List<String> artistIds;
    @JsonProperty("illustration_id")
    public String illustrationId;
    @JsonProperty("border_color")
    public String borderColor;
    @JsonProperty("frame")
    public String frame;
    @JsonProperty("full_art")
    public Boolean fullArt;
    @JsonProperty("textless")
    public Boolean textless;
    @JsonProperty("booster")
    public Boolean booster;
    @JsonProperty("story_spotlight")
    public Boolean storySpotlight;
    @JsonProperty("edhrec_rank")
    public Integer edhrecRank;
    @JsonProperty("penny_rank")
    public Integer pennyRank;
    @JsonProperty("prices")
    public Prices prices;
    @JsonProperty("related_uris")
    public RelatedUris relatedUris;
    @JsonProperty("purchase_uris")
    public PurchaseUris purchaseUris;
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
