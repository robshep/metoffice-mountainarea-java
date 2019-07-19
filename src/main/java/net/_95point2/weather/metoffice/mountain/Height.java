
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
    "Level",
    "WindDirection",
    "WindSpeed",
    "MaxGust",
    "Temperature",
    "FeelsLike"
})
public class Height {

    @JsonProperty("Level")
    private String level;
    @JsonProperty("WindDirection")
    private String windDirection;
    @JsonProperty("WindSpeed")
    private Integer windSpeed;
    @JsonProperty("MaxGust")
    private Integer maxGust;
    @JsonProperty("Temperature")
    private Integer temperature;
    @JsonProperty("FeelsLike")
    private Integer feelsLike;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("Level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("WindDirection")
    public String getWindDirection() {
        return windDirection;
    }

    @JsonProperty("WindDirection")
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    @JsonProperty("WindSpeed")
    public Integer getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("WindSpeed")
    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("MaxGust")
    public Integer getMaxGust() {
        return maxGust;
    }

    @JsonProperty("MaxGust")
    public void setMaxGust(Integer maxGust) {
        this.maxGust = maxGust;
    }

    @JsonProperty("Temperature")
    public Integer getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("FeelsLike")
    public Integer getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("FeelsLike")
    public void setFeelsLike(Integer feelsLike) {
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
