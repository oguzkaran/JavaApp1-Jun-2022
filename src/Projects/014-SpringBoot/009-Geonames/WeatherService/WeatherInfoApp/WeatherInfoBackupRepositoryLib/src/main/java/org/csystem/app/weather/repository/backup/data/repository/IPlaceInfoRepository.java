package org.csystem.app.weather.repository.backup.data.repository;

import org.csystem.app.weather.repository.backup.data.entity.PlaceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("placeInfoBackupRepository")
public interface IPlaceInfoRepository extends CrudRepository<PlaceInfo, Integer> {

}
