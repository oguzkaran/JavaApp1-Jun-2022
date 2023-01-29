package com.metemengen.animalhospital.data.entity.orm;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal { //POJO (Plain Old Java Object)
    @Id
    @Column(name = "animal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(length = 100, nullable = false)
    public String name;

    @Column(length = 100, nullable = false)
    public String type;

    @Column(name = "birth_date", nullable = false)
    public LocalDate birthDate;

    @Column(nullable = false)
    public boolean sterile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    //@JsonIgnore
    public Owner owner;

    @ManyToMany(mappedBy = "animals", fetch = FetchType.LAZY)
    public Set<Veterinarian> veterinarians;

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Animal a && a.id == id;
    }
}
