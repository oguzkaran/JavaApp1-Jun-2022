package org.csystem.app.weather.repository.backup.data.repository;

import org.csystem.app.weather.repository.backup.data.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("weatherInfoBackupRepository")
public interface IWeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {

}
