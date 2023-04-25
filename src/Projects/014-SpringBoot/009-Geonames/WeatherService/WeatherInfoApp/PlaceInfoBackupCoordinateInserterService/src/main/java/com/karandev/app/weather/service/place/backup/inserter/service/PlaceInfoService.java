package com.karandev.app.weather.service.place.backup.inserter.service;

import com.karandev.app.weather.service.place.backup.inserter.dto.PlaceInfoSaveDTO;
import com.karandev.app.weather.service.place.backup.inserter.mapper.IPlaceInfoMapper;
import org.csystem.app.weather.repository.backup.data.dal.WeatherInfoBackupAppHelper;
import org.springframework.stereotype.Service;

@Service
public class PlaceInfoService {
    public final WeatherInfoBackupAppHelper m_placeInfoServiceHelper;
    public final IPlaceInfoMapper m_placeInfoMapper;

    public PlaceInfoService(WeatherInfoBackupAppHelper placeInfoServiceHelper, IPlaceInfoMapper placeInfoMapper)
    {
        m_placeInfoServiceHelper = placeInfoServiceHelper;
        m_placeInfoMapper = placeInfoMapper;
    }

    public PlaceInfoSaveDTO savePlaceInfo(PlaceInfoSaveDTO placeInfoDTO)
    {
        var pi = m_placeInfoMapper.toPlaceInfo(placeInfoDTO);
        m_placeInfoServiceHelper.savePlaceInfo(pi);

        return m_placeInfoMapper.toPlaceInfoDto(pi);
    }

    public void deleteById(int id)
    {
        m_placeInfoServiceHelper.deletePlaceInfoById(id);
    }

}
