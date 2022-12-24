package com.metemengen.animalhospital.data.entity;

import java.time.LocalDate;

public class VeterinarianSave { //POJO (Plain Old Java Object)
    public long diplomaNo;
    public String citizenId;
    public String firstName;
    public String middleName;
    public String lastName;
    public LocalDate birthDate;
    public LocalDate registerDate;

    //...

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
