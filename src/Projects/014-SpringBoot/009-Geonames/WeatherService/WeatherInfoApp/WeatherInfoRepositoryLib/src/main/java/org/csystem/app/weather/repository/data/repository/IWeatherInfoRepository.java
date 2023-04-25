package org.csystem.app.weather.repository.data.repository;

import org.csystem.app.weather.repository.data.entity.PlaceInfo;
import org.csystem.app.weather.repository.data.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IWeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {
    boolean existsByPlaceInfoAndDatetimeAndStationName(@Param("pi") PlaceInfo pi, @Param("dateTime") LocalDateTime dateTime,
                                                       @Param("stationName") String stationName);

    @Query(value = "select w from WeatherInfo w inner join PlaceInfo p on p = w.placeInfo where p.placeName = :placeName")
    Iterable<WeatherInfo> findByPlaceName(@Param("placeName") String placeName);

    @Query(value = "select w from WeatherInfo w inner join PlaceInfo p on p = w.placeInfo where p.id = :placeId")
    Iterable<WeatherInfo> findByPlaceId(@Param("placeId") int placeId);

    Iterable<WeatherInfo> findByPlaceInfo(@Param("placeInfo") PlaceInfo pi);

    @Query(value = "select w.place_info_id, w.weather_information_id, w.lng, w.observation, w.iCAO, w.clouds, w.dew_point, w.clouds_code, "
            + "w.date_time, w.temperature, w.humidity, w.station_name, w.weather_condition, w.wind_direction, w.wind_speed, "
            + "w.lat, w.weather_condition_code, w.sea_level_pressure, w.hecto_pasc_alimeter "
            + "from weather_information w inner join place_info p on p.place_info_id =  w.place_info_id "
            + "where p.place_name = :placeName and date_part('hour', w.date_time) = :hour and date_part('minute', w.date_time) = :minute",
            nativeQuery = true)
    Iterable<WeatherInfo> findByPlaceNameAndHourAndMinute(@Param("placeName") String placeName,
                                                          @Param("hour") int hour,
                                                          @Param("minute") int minute);

    @Modifying
    @Query(value = "truncate table weather_information restart identity", nativeQuery = true)
    void truncate();
}
