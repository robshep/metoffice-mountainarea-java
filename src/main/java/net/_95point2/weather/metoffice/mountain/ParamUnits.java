
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
    "WindSpeed",
    "MaxGust",
    "Temperature",
    "FeelsLike"
})
public class ParamUnits {

    @JsonProperty("WindSpeed")
    private String windSpeed;
    @JsonProperty("MaxGust")
    private String maxGust;
    @JsonProperty("Temperature")
    private String temperature;
    @JsonProperty("FeelsLike")
    private String feelsLike;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("WindSpeed")
    public String getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("WindSpeed")
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("MaxGust")
    public String getMaxGust() {
        return maxGust;
    }

    @JsonProperty("MaxGust")
    public void setMaxGust(String maxGust) {
        this.maxGust = maxGust;
    }

    @JsonProperty("Temperature")
    public String getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("FeelsLike")
    public String getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("FeelsLike")
    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
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
