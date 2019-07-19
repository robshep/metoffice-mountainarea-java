
package net._95point2.weather.metoffice.mountain;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.List;
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
    "End",
    "Start",
    "SignificantWeather",
    "Precipitation",
    "Height",
    "FreezingLevel"
})
public class Period {

    @JsonProperty("End")
    private String end;
    @JsonProperty("Start")
    private String start;
    @JsonProperty("SignificantWeather")
    @Valid
    private SignificantWeather significantWeather;
    @JsonProperty("Precipitation")
    @Valid
    private Precipitation precipitation;
    @JsonProperty("Height")
    @Valid
    private List<Height> height = null;
    @JsonProperty("FreezingLevel")
    private String freezingLevel;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("End")
    public String getEnd() {
        return end;
    }

    @JsonProperty("End")
    public void setEnd(String end) {
        this.end = end;
    }

    @JsonProperty("Start")
    public String getStart() {
        return start;
    }

    @JsonProperty("Start")
    public void setStart(String start) {
        this.start = start;
    }

    @JsonProperty("SignificantWeather")
    public SignificantWeather getSignificantWeather() {
        return significantWeather;
    }

    @JsonProperty("SignificantWeather")
    public void setSignificantWeather(SignificantWeather significantWeather) {
        this.significantWeather = significantWeather;
    }

    @JsonProperty("Precipitation")
    public Precipitation getPrecipitation() {
        return precipitation;
    }

    @JsonProperty("Precipitation")
    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    @JsonProperty("Height")
    public List<Height> getHeight() {
        return height;
    }

    @JsonProperty("Height")
    public void setHeight(List<Height> height) {
        this.height = height;
    }

    @JsonProperty("FreezingLevel")
    public String getFreezingLevel() {
        return freezingLevel;
    }

    @JsonProperty("FreezingLevel")
    public void setFreezingLevel(String freezingLevel) {
        this.freezingLevel = freezingLevel;
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
