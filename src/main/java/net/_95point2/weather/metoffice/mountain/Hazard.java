
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
    "Element",
    "Likelihood"
})
@ToString
public class Hazard {

    @JsonProperty("Element")
    @Valid
    private Element element;
    @JsonProperty("Likelihood")
    @Valid
    private Likelihood likelihood;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Element")
    public Element getElement() {
        return element;
    }

    @JsonProperty("Element")
    public void setElement(Element element) {
        this.element = element;
    }

    @JsonProperty("Likelihood")
    public Likelihood getLikelihood() {
        return likelihood;
    }

    @JsonProperty("Likelihood")
    public void setLikelihood(Likelihood likelihood) {
        this.likelihood = likelihood;
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
