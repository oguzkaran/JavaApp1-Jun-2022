package com.metemengen.animalhospital.data.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @Column(name = "owner_id")
    public int id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, length = 14)
    public String phone;

    @Column(nullable = false, length = 512)
    public String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    public Set<Animal> animals;
}
