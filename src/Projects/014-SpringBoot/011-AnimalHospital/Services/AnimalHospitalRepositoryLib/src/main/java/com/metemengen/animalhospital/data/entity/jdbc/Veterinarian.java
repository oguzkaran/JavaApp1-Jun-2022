package com.metemengen.animalhospital.data.entity.jdbc;

import java.time.LocalDate;
import java.util.Optional;

public class Veterinarian {
    public long diplomaNo;
    public String citizenId;
    public String firstName;
    public Optional<String> middleName;

    public String lastName;

    public LocalDate birthDate;

    public LocalDate registerDate;

    public Veterinarian()
    {
    }

    public Veterinarian(long diplomaNo, String citizenId, String firstName, String lastName, LocalDate birthDate, LocalDate registerDate)
    {
        this(diplomaNo, citizenId, firstName, Optional.empty(), lastName, birthDate, registerDate);
    }

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

    public long getDiplomaNo()
    {
        return diplomaNo;
    }

    public void setDiplomaNo(long diplomaNo)
    {
        this.diplomaNo = diplomaNo;
    }

    public String getCitizenId()
    {
        return citizenId;
    }

    public void setCitizenId(String citizenId)
    {
        this.citizenId = citizenId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName.orElse(null);
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = Optional.ofNullable(middleName);
    }

    public Optional<String> getMiddleNameOpt()
    {
        return middleName;
    }

    public void setMiddleNameOpt(Optional<String> middleName)
    {
        this.middleName = middleName;
    }


    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public LocalDate getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate)
    {
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
