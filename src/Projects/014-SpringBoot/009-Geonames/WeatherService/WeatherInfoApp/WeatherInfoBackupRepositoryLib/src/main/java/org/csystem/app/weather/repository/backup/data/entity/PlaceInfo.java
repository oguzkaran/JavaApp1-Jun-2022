package org.csystem.app.weather.repository.backup.data.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "place_info")
public class PlaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_info_id")
    public int id;
    @Column(name = "place_name", nullable = false, unique = true)
    public String placeName;

    @Column(nullable = false)
    public String country;

    @Column(nullable = false)
    public int code;

    @Column(nullable = false)
    public double north;

    @Column(nullable = false)
    public double south;

    @Column(nullable = false)
    public double east;

    @Column(nullable = false)
    public double west;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "placeInfo", cascade = CascadeType.ALL)
    public Set<WeatherInfo> weatherInfos;
}
