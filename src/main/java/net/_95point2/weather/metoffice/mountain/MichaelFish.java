package net._95point2.weather.metoffice.mountain;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

/**
 * Get a forecast.
 * @author rob
 *
 */
public class MichaelFish
{
	public Forecast saysFor(String region, String datapoint_key)
	{
		try {
			HttpResponse<InputStream> response = Unirest.get("http://datapoint.metoffice.gov.uk/public/data/txt/wxfcs/mountainarea/json/" + region)
			.queryString("key", datapoint_key)
			.asBinary();
			
			if(response.getStatus() == 200){
				return new ObjectMapper().readValue(response.getRawBody(), Forecast.class);
			}
			else {
				throw new RuntimeException("bad 1");
			}
		}
		catch(Exception e){
			throw new RuntimeException("bad 2", e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new MichaelFish().saysFor(args[0], args[1]).getReport());
	}
}
