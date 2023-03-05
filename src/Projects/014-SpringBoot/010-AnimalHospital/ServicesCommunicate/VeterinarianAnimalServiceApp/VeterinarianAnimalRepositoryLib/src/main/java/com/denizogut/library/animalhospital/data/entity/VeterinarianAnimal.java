package com.denizogut.library.animalhospital.data.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "veterinarians_to_animals")
public class VeterinarianAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veterinary_to_animal_id")
    public long id;

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
