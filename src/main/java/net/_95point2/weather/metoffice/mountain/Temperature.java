
package net._95point2.weather.metoffice.mountain;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Peak",
    "Valley",
    "Freezing"
})
public class Temperature {

    @JsonProperty("Peak")
    @Valid
    private Peak peak;
    @JsonProperty("Valley")
    @Valid
    private Valley valley;
    @JsonProperty("Freezing")
    private String freezing;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Peak")
    public Peak getPeak() {
        return peak;
    }

    @JsonProperty("Peak")
    public void setPeak(Peak peak) {
        this.peak = peak;
    }

    @JsonProperty("Valley")
    public Valley getValley() {
        return valley;
    }

    @JsonProperty("Valley")
    public void setValley(Valley valley) {
        this.valley = valley;
    }

    @JsonProperty("Freezing")
    public String getFreezing() {
        return freezing;
    }

    @JsonProperty("Freezing")
    public void setFreezing(String freezing) {
        this.freezing = freezing;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
