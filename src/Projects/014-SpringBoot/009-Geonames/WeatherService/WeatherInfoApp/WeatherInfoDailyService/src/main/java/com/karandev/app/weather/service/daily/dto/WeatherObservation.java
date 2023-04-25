package com.karandev.app.weather.service.daily.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherObservation {
    public double lng;
    public String observation;
    @JsonProperty("ICAO")
    public String iCAO;
    public String clouds;
    public String dewPoint;
    public String cloudsCode;
    public String datetime;
    public String temperature;
    public int humidity;
    public String stationName;
    public String weatherCondition;
    public int windDirection;
    public String windSpeed;
    public double lat;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String weatherConditionCode;
    public double seaLevelPressure;
    public int hectoPascAltimeter;

}

