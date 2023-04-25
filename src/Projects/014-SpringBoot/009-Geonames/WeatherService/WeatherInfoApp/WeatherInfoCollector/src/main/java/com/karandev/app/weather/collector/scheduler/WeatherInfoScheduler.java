package com.karandev.app.weather.collector.scheduler;

import com.karandev.app.weather.collector.geonames.WeatherObservations;
import com.karandev.app.weather.collector.mapper.IWeatherInfoMapper;
import org.csystem.app.weather.repository.data.dal.WeatherInfoAppHelper;
import org.csystem.app.weather.repository.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class WeatherInfoScheduler {
    private final WeatherInfoAppHelper m_weatherInfoAppHelper;
    private final RestTemplate m_restTemplate;
    private final IWeatherInfoMapper m_weatherMapper;

    @Value("${geonames.url}")
    private String m_urlTemplate;

    private void weatherInfoCallback(WeatherInfo wi, PlaceInfo pi)
    {
        wi.placeInfo = pi;
        if (m_weatherInfoAppHelper.existsByPlaceInfoAndDatetimeAndStationName(pi, wi.datetime, wi.stationName))
            return;

        m_weatherInfoAppHelper.saveWeatherInfo(wi);
    }

    private void schedulerCallback(PlaceInfo pi)
    {
        var url = String.format(m_urlTemplate, pi.north, pi.south, pi.east, pi.west);
        var wos = m_restTemplate.getForObject(url, WeatherObservations.class);

        wos.weatherObservations.stream().map(m_weatherMapper::toWeatherInfo).forEach(wi -> weatherInfoCallback(wi, pi));
    }

    public WeatherInfoScheduler(WeatherInfoAppHelper weatherInfoAppHelper, RestTemplate restTemplate, IWeatherInfoMapper weatherMapper)
    {
        m_weatherInfoAppHelper = weatherInfoAppHelper;
        m_restTemplate = restTemplate;
        m_weatherMapper = weatherMapper;
    }

    //@Scheduled(cron = "0 33 16 * * *")
    @Scheduled(cron = "0 0 1,2,3,13,14,15 * * *")
    public void schedulerCallback()
    {
        Console.writeLine("Schedule");
        var places = m_weatherInfoAppHelper.findAllPlaces();

        places.forEach(this::schedulerCallback);
    }
}
