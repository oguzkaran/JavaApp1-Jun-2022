package org.csystem.app.weather.repository.data.dal;

import org.csystem.app.weather.repository.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.csystem.app.weather.repository.data.repository.IPlaceInfoRepository;
import org.csystem.app.weather.repository.data.repository.IWeatherInfoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class WeatherInfoAppHelper {
    private final IPlaceInfoRepository m_placeInfoRepository;
    private final IWeatherInfoRepository m_weatherInfoRepository;

    public WeatherInfoAppHelper(IPlaceInfoRepository placeInfoRepository, IWeatherInfoRepository weatherInfoRepository)
    {
        m_placeInfoRepository = placeInfoRepository;
        m_weatherInfoRepository = weatherInfoRepository;
    }

    public boolean existsByPlaceInfoAndDatetimeAndStationName(PlaceInfo pi, LocalDateTime dateTime, String stationName)
    {
        return m_weatherInfoRepository.existsByPlaceInfoAndDatetimeAndStationName(pi, dateTime, stationName);
    }

    public Iterable<PlaceInfo> findAllPlaces()
    {
        return m_placeInfoRepository.findAll();
    }

    public void savePlaceInfo(PlaceInfo placeInfo)
    {
        m_placeInfoRepository.save(placeInfo);
    }

    public void saveWeatherInfo(WeatherInfo weatherInfo)
    {
        m_weatherInfoRepository.save(weatherInfo);
    }


    public PlaceInfo findPlaceWeatherInfoByPlaceName(String placeName)
    {
        return m_placeInfoRepository.findByPlaceName(placeName);
    }

    public Iterable<WeatherInfo> findWeatherInfoByPlaceName(String placeName)
    {
        return m_weatherInfoRepository.findByPlaceName(placeName);
    }

    public Iterable<WeatherInfo> findByPlaceNameAndHourAndMinute(String placeName, int hour, int minute)
    {
        return m_weatherInfoRepository.findByPlaceNameAndHourAndMinute(placeName, hour, minute);
    }

    @Transactional("weatherInfoTransactionManager")
    public void deleteAllWeatherInfo()
    {
        m_weatherInfoRepository.truncate();
    }

    public void deletePlaceInfoById(int id)
    {
        m_placeInfoRepository.deleteById(id);
    }

    //...
}
