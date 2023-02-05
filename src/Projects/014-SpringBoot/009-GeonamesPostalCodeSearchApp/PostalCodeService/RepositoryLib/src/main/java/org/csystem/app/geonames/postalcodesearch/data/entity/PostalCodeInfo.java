package org.csystem.app.geonames.postalcodesearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "postal_code_info")
public class PostalCodeInfo {
    @Id
    public String code;

    @Column(name = "query_date", nullable = false)
    public LocalDate queryDate = LocalDate.now();

    @Column(name = "query_count", nullable = false)
    public int queryCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postalCodeInfo", cascade = CascadeType.ALL)
    public List<PostalCode> postalCodes;

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
