package org.csystem.app.geonames.postalcodesearch.data.repository;

import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeInfo;
import org.csystem.app.geonames.postalcodesearch.data.entity.PostalCodeQueryInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostalCodeInfoRepository extends CrudRepository<PostalCodeInfo, String> {
    @Query("update PostalCodeInfo pi set pi.queryCount = pi.queryCount + 1 where pi.code = :code")
    @Modifying
    int updateQueryCount(@Param("code") String code);
}
