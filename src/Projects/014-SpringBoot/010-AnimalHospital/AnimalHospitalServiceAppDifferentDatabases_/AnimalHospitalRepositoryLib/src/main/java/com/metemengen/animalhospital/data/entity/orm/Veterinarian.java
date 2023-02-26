package com.metemengen.animalhospital.data.entity.orm;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "veterinarians")
public class Veterinarian {
    @Id
    @Column(name = "diploma_no")
    public long diplomaNo;

    @Column(name = "citizen_id", unique = true, nullable = false)
    public String citizenId;

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @Column(name = "last_name", nullable = false)
    public String lastName;

    @Column(name = "birth_date", nullable = false)
    public LocalDate birthDate;

    @Column(name = "register_date", nullable = false)
    public LocalDate registerDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "veterinarians_to_animals", joinColumns = @JoinColumn(name = "diploma_no", referencedColumnName = "diploma_no", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "animal_id", referencedColumnName = "animal_id", nullable = false))
    public Set<Animal> animals;

    @Override
    public int hashCode()
    {
        return Long.valueOf(diplomaNo).hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Veterinarian v && v.diplomaNo == diplomaNo;
    }
}
