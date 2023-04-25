package com.karandev.app.weather.backup.scheduler;

import com.karandev.app.weather.backup.mapper.IWeatherInfoMapper;
import org.csystem.app.weather.repository.backup.data.dal.WeatherInfoBackupAppHelper;
import org.csystem.app.weather.repository.backup.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.data.dal.WeatherInfoAppHelper;
import org.csystem.util.console.Console;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Configuration
@EnableScheduling
public class WeatherInfoScheduler {
    private final WeatherInfoAppHelper m_weatherInfoAppHelper;
    private final WeatherInfoBackupAppHelper m_weatherInfoBackupAppHelper;
    private final IWeatherInfoMapper m_weatherMapper;

    private void schedulerCallback(PlaceInfo pi)
    {
        var wos = m_weatherInfoAppHelper.findWeatherInfoByPlaceName(pi.placeName);

        m_weatherInfoBackupAppHelper.saveAllWeatherInfo(StreamSupport.stream(wos.spliterator(), false)
                .map(m_weatherMapper::toWeatherInfoBackup).peek(wi -> wi.placeInfo = pi).collect(Collectors.toList()));
    }

    public WeatherInfoScheduler(WeatherInfoAppHelper weatherInfoAppHelper,
                                WeatherInfoBackupAppHelper weatherInfoBackupAppHelper,
                                IWeatherInfoMapper weatherMapper)
    {
        m_weatherInfoAppHelper = weatherInfoAppHelper;
        m_weatherInfoBackupAppHelper = weatherInfoBackupAppHelper;
        m_weatherMapper = weatherMapper;
    }

    //@Scheduled(cron = "0 34 16 * * *")
    @Scheduled(cron = "0 50 23 * * *")
    public void schedulerCallback()
    {
        Console.writeLine("Schedule");
        var places = m_weatherInfoBackupAppHelper.findAllPlaces();

        places.forEach(this::schedulerCallback);
        m_weatherInfoAppHelper.deleteAllWeatherInfo();
    }
}
