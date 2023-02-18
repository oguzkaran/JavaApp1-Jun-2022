package org.csystem.app.geonames.postalcodesearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "postal_code_query_info")
public class PostalCodeQueryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postal_code_query_info_id")
    public long id;

    @Column(name = "query_date_time", nullable = false)
    public LocalDateTime queryDateTime = LocalDateTime.now();

    @Column(name = "query_value", nullable = false)
    public int queryValue;

    //...
}
