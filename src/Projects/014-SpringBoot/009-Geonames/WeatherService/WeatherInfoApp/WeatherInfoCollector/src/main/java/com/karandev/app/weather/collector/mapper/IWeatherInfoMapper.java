package com.karandev.app.weather.collector.mapper;

import com.karandev.app.weather.collector.geonames.WeatherObservation;
import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "WeatherInfoMapperImpl", componentModel = "spring")
public interface IWeatherInfoMapper {
    @Mapping(source = "datetime", target = "datetime", dateFormat = "yyyy-MM-dd kk:mm:ss")
    WeatherInfo toWeatherInfo(WeatherObservation weatherObservation);
}
