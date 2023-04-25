package org.csystem.app.weather.repository.backup.data.dal;

import org.csystem.app.weather.repository.backup.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.backup.data.entity.WeatherInfo;
import org.csystem.app.weather.repository.backup.data.repository.IPlaceInfoRepository;
import org.csystem.app.weather.repository.backup.data.repository.IWeatherInfoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoBackupAppHelper {
    private final IPlaceInfoRepository m_placeInfoRepository;
    private final IWeatherInfoRepository m_weatherInfoRepository;

    public WeatherInfoBackupAppHelper(@Qualifier("placeInfoBackupRepository") IPlaceInfoRepository placeInfoRepository,
                                      @Qualifier("weatherInfoBackupRepository") IWeatherInfoRepository weatherInfoRepository)
    {
        m_placeInfoRepository = placeInfoRepository;
        m_weatherInfoRepository = weatherInfoRepository;
    }

    public Iterable<PlaceInfo> findAllPlaces()
    {
        return m_placeInfoRepository.findAll();
    }

    public void saveWeatherInfo(WeatherInfo weatherInfo)
    {
        m_weatherInfoRepository.save(weatherInfo);
    }

    public void savePlaceInfo(PlaceInfo placeInfo)
    {
        m_placeInfoRepository.save(placeInfo);
    }

    public void saveAllWeatherInfo(Iterable<WeatherInfo> weatherInfos)
    {
        m_weatherInfoRepository.saveAll(weatherInfos);
    }

    public void deletePlaceInfoById(int id)
    {
        m_placeInfoRepository.deleteById(id);
    }

    //...
}
