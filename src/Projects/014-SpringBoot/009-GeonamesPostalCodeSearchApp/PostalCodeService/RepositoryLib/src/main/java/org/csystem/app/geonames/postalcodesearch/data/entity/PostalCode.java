package org.csystem.app.geonames.postalcodesearch.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "postal_codes")
public class PostalCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postal_code_id")
    public long id;

    @Column(name = "admin_code2")
    public String adminCode2;

    @Column(name = "admin_code1")
    public String adminCode1;


    @Column(name = "admin_name2")
    public String adminName2;

    @Column(nullable = false)
    public double longitude;

    @Column(name = "admin_name1")
    public String adminName1;

    public String plate;

    @Column(name = "place_name")
    public String placeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code", nullable = false)
    public PostalCodeInfo postalCodeInfo;

    @Column(nullable = false)
    public double latitude;

    @Override
    public int hashCode()
    {
        return Long.hashCode(id);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PostalCode postalCode && postalCode.id == id;
    }
}
