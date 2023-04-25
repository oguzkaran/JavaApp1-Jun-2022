package com.karandev.app.weather.service.daily.controller;

import com.karandev.app.weather.service.daily.dto.WeatherObservations;
import com.karandev.app.weather.service.daily.service.WeatherInfoDailyServiceAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather/info")
public class WeatherInfoDailyServiceAppController {
    private final WeatherInfoDailyServiceAppService m_weatherInfoDailyServiceAppService;


    public WeatherInfoDailyServiceAppController(WeatherInfoDailyServiceAppService weatherInfoDailyServiceAppService)
    {
        m_weatherInfoDailyServiceAppService = weatherInfoDailyServiceAppService;
    }

    @GetMapping("place")
    public WeatherObservations findByPlaceName(@RequestParam("p") String placeName)
    {
        return m_weatherInfoDailyServiceAppService.findWeatherInfoByPlaceName(placeName);
    }

    @GetMapping("place/hm")
    public WeatherObservations findWeatherInfoByPlaceNameAndHourAndMinute(@RequestParam("p") String placeName,
                                               @RequestParam("h") int hour,
                                               @RequestParam("m") int minute)
    {
        return m_weatherInfoDailyServiceAppService.findWeatherInfoByPlaceNameAndHourAndMinute(placeName, hour, minute);
    }
}
