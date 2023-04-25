package com.karandev.app.weather.service.daily.mapper;


import com.karandev.app.weather.service.daily.dto.WeatherObservation;
import com.karandev.app.weather.service.daily.dto.WeatherObservations;
import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "WeatherInfoMapperImpl", componentModel = "spring")
public interface IWeatherInfoMapper {
    @Mapping(source = "datetime", target = "datetime", dateFormat = "yyyy-MM-dd kk:mm:ss")
    WeatherObservation toWeatherObservation(WeatherInfo weatherInfo);

    default WeatherObservations toWeatherObservations(List<WeatherObservation> weatherObservations)
    {
        var dto = new WeatherObservations();

        dto.weatherObservations = weatherObservations;

        return dto;
    }
}
