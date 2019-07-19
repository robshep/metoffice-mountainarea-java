
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

import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Location",
    "Issue",
    "Issued",
    "Type",
    "ParamUnits",
    "Days"
})
@ToString
public class Report {

    @JsonProperty("Location")
    private String location;
    @JsonProperty("Issue")
    private String issue;
    @JsonProperty("Issued")
    private String issued;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("ParamUnits")
    @Valid
    private ParamUnits paramUnits;
    @JsonProperty("Days")
    @Valid
    private Days days;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("Location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("Issue")
    public String getIssue() {
        return issue;
    }

    @JsonProperty("Issue")
    public void setIssue(String issue) {
        this.issue = issue;
    }

    @JsonProperty("Issued")
    public String getIssued() {
        return issued;
    }

    @JsonProperty("Issued")
    public void setIssued(String issued) {
        this.issued = issued;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("ParamUnits")
    public ParamUnits getParamUnits() {
        return paramUnits;
    }

    @JsonProperty("ParamUnits")
    public void setParamUnits(ParamUnits paramUnits) {
        this.paramUnits = paramUnits;
    }

    @JsonProperty("Days")
    public Days getDays() {
        return days;
    }

    @JsonProperty("Days")
    public void setDays(Days days) {
        this.days = days;
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
