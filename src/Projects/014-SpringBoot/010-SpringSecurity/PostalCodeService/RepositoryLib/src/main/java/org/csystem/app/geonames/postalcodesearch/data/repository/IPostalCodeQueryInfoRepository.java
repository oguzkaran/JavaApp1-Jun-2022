package org.csystem.app.geonames.postalcodesearch.data.repository;

import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeQueryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  IPostalCodeQueryInfoRepository extends CrudRepository<PostalCodeQueryInfo, Long> {

}
