
package fr.livar.mtg.mtgdecklist.scryfall.model.bulk;

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
    "object",
    "id",
    "type",
    "updated_at",
    "uri",
    "name",
    "description",
    "size",
    "download_uri",
    "content_type",
    "content_encoding"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("object")
    public String object;
    @JsonProperty("id")
    public String id;
    @JsonProperty("type")
    public String type;
    @JsonProperty("updated_at")
    public String updatedAt;
    @JsonProperty("uri")
    public String uri;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("size")
    public Integer size;
    @JsonProperty("download_uri")
    public String downloadUri;
    @JsonProperty("content_type")
    public String contentType;
    @JsonProperty("content_encoding")
    public String contentEncoding;
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
