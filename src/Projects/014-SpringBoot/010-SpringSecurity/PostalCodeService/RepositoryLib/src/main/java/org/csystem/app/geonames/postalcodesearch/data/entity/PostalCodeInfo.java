package org.csystem.app.geonames.postalcodesearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "postal_code_info")
public class PostalCodeInfo {
    @Id
    public String code;
    @Column(name = "save_datetime", nullable = false)
    public LocalDateTime saveDateTime = LocalDateTime.now();

    @Column(name = "query_count", nullable = false)
    public int queryCount = 1;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postalCodeInfo", cascade = CascadeType.ALL)
    public List<PostalCode> postalCodes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postalCodeInfo", cascade = CascadeType.ALL)
    public Set<PostalCodeQueryInfo> postalCodeQueryInfo;

    @Override
    public int hashCode()
    {
        return code.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PostalCodeInfo postalCodeInfo && postalCodeInfo.code.equals(code);
    }
}
