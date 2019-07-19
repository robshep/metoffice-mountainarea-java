
package net._95point2.weather.metoffice.mountain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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

import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Validity",
    "Headline",
    "Confidence",
    "View",
    "CloudFreeHillTop",
    "Weather",
    "Visibility",
    "Hazards",
    "Periods",
    "GroundConditions",
    "Wind",
    "HillCloud",
    "Temperature",
    "Summary"
})
@ToString
public class Day {

    @JsonProperty("Validity")
    private String validity;
    @JsonProperty("Headline")
    private String headline;
    @JsonProperty("Confidence")
    private String confidence;
    @JsonProperty("View")
    private String view;
    @JsonProperty("CloudFreeHillTop")
    private String cloudFreeHillTop;
    @JsonProperty("Weather")
    private String weather;
    @JsonProperty("Visibility")
    private String visibility;
    @JsonProperty("Hazards")
    @Valid
    private Hazards hazards;
    @JsonProperty("Periods")
    @Valid
    private Periods periods;
    @JsonProperty("GroundConditions")
    @Valid
    private GroundConditions groundConditions;
    @JsonProperty("Wind")
    private String wind;
    @JsonProperty("HillCloud")
    private String hillCloud;
    @JsonProperty("Temperature")
    @Valid
    private Temperature temperature;
    @JsonProperty("Summary")
    private String summary;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private ZonedDateTime validityDateTime;

    @JsonIgnore
    
    
    @JsonProperty("Validity")
    public String getValidity() {
        return validity;
    }
    
    @JsonIgnore
    public ZonedDateTime getValidityDateTime() {
		return validityDateTime;
	}

    @JsonProperty("Validity")
    public void setValidity(String validity) {
        this.validity = validity;
        this.validityDateTime = ZonedDateTime.of(LocalDateTime.parse(validity, dateTimeFmt), ZoneId.of("Europe/London") );
    }

    @JsonProperty("Headline")
    public String getHeadline() {
        return headline;
    }

    @JsonProperty("Headline")
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @JsonProperty("Confidence")
    public String getConfidence() {
        return confidence;
    }

    @JsonProperty("Confidence")
    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    @JsonProperty("View")
    public String getView() {
        return view;
    }

    @JsonProperty("View")
    public void setView(String view) {
        this.view = view;
    }

    @JsonProperty("CloudFreeHillTop")
    public String getCloudFreeHillTop() {
        return cloudFreeHillTop;
    }

    @JsonProperty("CloudFreeHillTop")
    public void setCloudFreeHillTop(String cloudFreeHillTop) {
        this.cloudFreeHillTop = cloudFreeHillTop;
    }

    @JsonProperty("Weather")
    public String getWeather() {
        return weather;
    }

    @JsonProperty("Weather")
    public void setWeather(String weather) {
        this.weather = weather;
    }

    @JsonProperty("Visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("Visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("Hazards")
    public Hazards getHazards() {
        return hazards;
    }

    @JsonProperty("Hazards")
    public void setHazards(Hazards hazards) {
        this.hazards = hazards;
    }

    @JsonProperty("Periods")
    public Periods getPeriods() {
        return periods;
    }

    @JsonProperty("Periods")
    public void setPeriods(Periods periods) {
        this.periods = periods;
    }

    @JsonProperty("GroundConditions")
    public GroundConditions getGroundConditions() {
        return groundConditions;
    }

    @JsonProperty("GroundConditions")
    public void setGroundConditions(GroundConditions groundConditions) {
        this.groundConditions = groundConditions;
    }

    @JsonProperty("Wind")
    public String getWind() {
        return wind;
    }

    @JsonProperty("Wind")
    public void setWind(String wind) {
        this.wind = wind;
    }

    @JsonProperty("HillCloud")
    public String getHillCloud() {
        return hillCloud;
    }

    @JsonProperty("HillCloud")
    public void setHillCloud(String hillCloud) {
        this.hillCloud = hillCloud;
    }

    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("Summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("Summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    DateTimeFormatter dateTimeFmt = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mmX");

    @JsonIgnore
    public List<HazardSummary> getDayHazards()
    {
    	ArrayList<HazardSummary> summaries = new ArrayList<HazardSummary>();
    	
    	Hazards h1 = getHazards();
    	if(h1 == null){
    		return Collections.EMPTY_LIST;
    	}
    	List<Hazard> h2 = h1.getHazard();
    	if(h2 == null || h2.isEmpty()){
    		return Collections.EMPTY_LIST;
    	}
    	
    	for(Hazard h : getHazards().getHazard())
    	{
    		if( ! h.getLikelihood().getType().equals("NO_LIKELIHOOD") ){
    			summaries.add(new HazardSummary(h.getElement().getType(), h.getLikelihood().getType()));
    		}
    	}
    	
    	summaries.sort((hz1, hz2) -> {
			return likelihoodRank(hz2.getLikelihood()) - likelihoodRank(hz1.getLikelihood());
		});
    	
    	return summaries;
    }
    
    private int likelihoodRank(String likelihood) {
		if(likelihood.equals("HIGH_LIKELIHOOD")){
			return 3;
		}
		if(likelihood.equals("MEDIUM_LIKELIHOOD")){
			return 2;
		}
		if(likelihood.equals("LOW_LIKELIHOOD")){
			return 1;
		}
		return 0;
	}
    
    public static class HazardSummary
    {
    	private String element;
    	private String likelihood;
    	
    	public String getElement() {
			return element;
		}
    	
    	public String getLikelihood() {
			return likelihood;
		}

		public HazardSummary(String element, String likelihood) {
			super();
			this.element = element;
			this.likelihood = likelihood;
		}
    }
}
