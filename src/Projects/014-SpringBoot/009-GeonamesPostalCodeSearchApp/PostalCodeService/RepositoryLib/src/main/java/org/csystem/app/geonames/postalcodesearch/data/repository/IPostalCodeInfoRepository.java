package org.csystem.app.geonames.postalcodesearch.data.repository;

import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostalCodeInfoRepository extends CrudRepository<PostalCodeInfo, String> {

}
