package com.karandev.app.weather.service.place.inserter.controller;

import com.karandev.app.weather.service.place.inserter.dto.PlaceInfoSaveDTO;
import com.karandev.app.weather.service.place.inserter.service.PlaceInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/weather/info")
public class PlaceInfoInserterController {
    public final PlaceInfoService m_placeInfoService;

    public PlaceInfoInserterController(PlaceInfoService placeInfoService)
    {
        m_placeInfoService = placeInfoService;
    }

    @PostMapping("save")
    public PlaceInfoSaveDTO savePlaceInfo(@RequestBody PlaceInfoSaveDTO placeInfoDTO)
    {
        return m_placeInfoService.savePlaceInfo(placeInfoDTO);
    }

    @PostMapping("delete")
    public void deleteById(@RequestParam(name = "id") int id)
    {
        m_placeInfoService.deleteById(id);
    }
}
