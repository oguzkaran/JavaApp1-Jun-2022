package com.denizogut.library.animalhospital.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "veterinarians_to_animals")
public class VeterinarianAnimal {
    @Id
    public UUID uuid;

    @Column(name = "animal_id", nullable = false)
    public int animalId;

    @Column(name = "diploma_no", nullable = false)
    public long diplomaNo;

    @Column(name = "date_time", nullable = false)
    public LocalDateTime dateTime = LocalDateTime.now();

    public String description;

    @Column(nullable = false)
    public double price;
}
