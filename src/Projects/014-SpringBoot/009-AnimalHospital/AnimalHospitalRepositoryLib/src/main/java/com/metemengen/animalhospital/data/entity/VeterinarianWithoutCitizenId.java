package com.metemengen.animalhospital.data.entity;

import java.time.LocalDate;
import java.util.Optional;

public class VeterinarianWithoutCitizenId {
    public long diplomaNo;
    public String firstName;
    public Optional<String> middleName;

    public String lastName;

    public LocalDate birthDate;

    public LocalDate registerDate;

    public VeterinarianWithoutCitizenId()
    {}

    public VeterinarianWithoutCitizenId(long diplomaNo, String firstName, Optional<String> middleName, String lastName, LocalDate birthDate, LocalDate registerDate)
    {
        this.diplomaNo = diplomaNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
    }

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
