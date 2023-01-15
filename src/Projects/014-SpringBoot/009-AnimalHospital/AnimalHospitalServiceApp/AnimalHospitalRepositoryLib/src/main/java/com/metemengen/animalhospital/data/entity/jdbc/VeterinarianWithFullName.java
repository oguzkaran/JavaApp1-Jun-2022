package com.metemengen.animalhospital.data.entity.jdbc;

import java.time.LocalDate;

public class VeterinarianWithFullName { //POJO (Plain Old Java Object)
    public long diplomaNo;

    public String fullName;

    public LocalDate birthDate;

    public LocalDate registerDate;


    public VeterinarianWithFullName()
    {
    }

    public VeterinarianWithFullName(long diplomaNo, String fullName, LocalDate birthDate, LocalDate registerDate)
    {
        this.diplomaNo = diplomaNo;
        this.fullName = fullName;
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
        return obj instanceof VeterinarianWithFullName v && v.diplomaNo == diplomaNo;
    }
}
