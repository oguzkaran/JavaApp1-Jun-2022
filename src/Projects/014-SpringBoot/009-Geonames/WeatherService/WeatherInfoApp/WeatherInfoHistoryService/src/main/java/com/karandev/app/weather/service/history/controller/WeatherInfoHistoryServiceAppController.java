package com.karandev.app.weather.service.history.controller;

import com.karandev.app.weather.service.history.dto.WeatherObservations;
import com.karandev.app.weather.service.history.service.WeatherInfoDailyServiceAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather/info")
public class WeatherInfoHistoryServiceAppController {
    private final WeatherInfoDailyServiceAppService m_weatherInfoDailyServiceAppService;

    public WeatherInfoHistoryServiceAppController(WeatherInfoDailyServiceAppService weatherInfoDailyServiceAppService)
    {
        m_weatherInfoDailyServiceAppService = weatherInfoDailyServiceAppService;
    }

    @GetMapping("place/history/my")
    public WeatherObservations findByPlaceNameAndYearAndMonth(@RequestParam(value = "m") int month,
                                                              @RequestParam(value = "y")int year,
                                                              @RequestParam(value = "p") String placeName)
    {
        return m_weatherInfoDailyServiceAppService.findByPlaceNameAndYearAndMonth(placeName, year, month);
    }

    @GetMapping("place/history/month")
    public WeatherObservations findByPlaceNameAndMonth(@RequestParam(value = "m") int month,
                                                       @RequestParam(value = "p") String placeName)
    {
        return m_weatherInfoDailyServiceAppService.findByPlaceNameAndMonth(placeName, month);
    }
}
