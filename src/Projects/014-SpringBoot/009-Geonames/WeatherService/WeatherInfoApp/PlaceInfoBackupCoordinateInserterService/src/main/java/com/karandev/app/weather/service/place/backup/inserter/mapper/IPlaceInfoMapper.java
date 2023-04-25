package com.karandev.app.weather.service.place.backup.inserter.mapper;

import com.karandev.app.weather.service.place.backup.inserter.dto.PlaceInfoSaveDTO;
import org.csystem.app.weather.repository.backup.data.entity.PlaceInfo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PlaceInfoMapperImpl", componentModel = "spring")
public interface IPlaceInfoMapper {
    PlaceInfo toPlaceInfo(PlaceInfoSaveDTO placeInfoDTO);
    PlaceInfoSaveDTO toPlaceInfoDto(PlaceInfo placeInfo);
}
