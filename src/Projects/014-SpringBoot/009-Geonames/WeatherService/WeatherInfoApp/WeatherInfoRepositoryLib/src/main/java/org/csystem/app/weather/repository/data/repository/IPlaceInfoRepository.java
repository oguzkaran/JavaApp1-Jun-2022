package org.csystem.app.weather.repository.data.repository;

import org.csystem.app.weather.repository.data.entity.PlaceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRepository extends CrudRepository<PlaceInfo, Integer> {
    PlaceInfo findByPlaceName(@Param("name") String name);
}
