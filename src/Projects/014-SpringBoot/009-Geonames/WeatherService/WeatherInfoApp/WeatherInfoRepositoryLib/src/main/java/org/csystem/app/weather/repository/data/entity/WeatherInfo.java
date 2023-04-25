package org.csystem.app.weather.repository.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather_information")
public class WeatherInfo { //POJO (Plain Old Java Object)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_information_id")
    public long id;

    public double lng;

    public String observation;

    public String iCAO;

    public String clouds;

    @Column(name = "dew_point")
    public String dewPoint;

    @Column(name = "clouds_code")
    public String cloudsCode;

    @Column(name = "date_time")
    public LocalDateTime datetime;

    public String temperature;

    public int humidity;
    @Column(name = "station_name")
    public String stationName;

    @Column(name = "weather_condition")
    public String weatherCondition;

    @Column(name = "wind_direction")
    public int windDirection;

    @Column(name = "wind_speed")
    public String windSpeed;

    public double lat;

    @Column(name = "weather_condition_code")
    public String weatherConditionCode;

    @Column(name = "sea_level_pressure")
    public double seaLevelPressure;

    @Column(name = "hecto_pasc_alimeter")
    public int hectoPascAltimeter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_info_id", nullable = false)
    @JsonIgnore
    public PlaceInfo placeInfo;
}
