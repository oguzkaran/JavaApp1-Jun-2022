package com.metemengen.animalhospital.data.entity;

import java.time.LocalDate;
import java.util.Optional;

public class Veterinarian { //POJO (Plain Old Java Object)
    public long diplomaNo;
    public String citizenId;
    public String firstName;
    public Optional<String> middleName;

    public String lastName;

    public LocalDate birthDate;

    public LocalDate registerDate;

    public Veterinarian(long diplomaNo, String citizenId, String firstName, Optional<String> middleName, String lastName, LocalDate birthDate, LocalDate registerDate)
    {
        this.diplomaNo = diplomaNo;
        this.citizenId = citizenId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
    }

    //...
}
