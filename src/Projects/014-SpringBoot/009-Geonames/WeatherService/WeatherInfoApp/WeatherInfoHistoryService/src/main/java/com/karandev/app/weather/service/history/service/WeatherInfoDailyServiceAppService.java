package com.karandev.app.weather.service.history.service;

import com.karandev.app.weather.service.history.dto.WeatherObservations;
import com.karandev.app.weather.service.history.mapper.IWeatherInfoMapper;
import org.csystem.app.weather.repository.backup.data.dal.WeatherInfoBackupAppHelper;
import org.springframework.stereotype.Service;

@Service
public class WeatherInfoDailyServiceAppService {
    private final WeatherInfoBackupAppHelper m_weatherInfoBackupAppHelper;
    private final IWeatherInfoMapper m_weatherInfoMapper;

    public WeatherInfoDailyServiceAppService(WeatherInfoBackupAppHelper weatherInfoBackupAppHelper, IWeatherInfoMapper weatherInfoMapper)
    {
        m_weatherInfoBackupAppHelper = weatherInfoBackupAppHelper;
        m_weatherInfoMapper = weatherInfoMapper;
    }

    public WeatherObservations findByPlaceNameAndYearAndMonth(String placeName, int year, int month)
    {
        throw new UnsupportedOperationException("Not implementee yet!...");
    }


    public WeatherObservations findByPlaceNameAndMonth(String placeName, int month)
    {
        throw new UnsupportedOperationException("Not implementee yet!...");
    }
}
