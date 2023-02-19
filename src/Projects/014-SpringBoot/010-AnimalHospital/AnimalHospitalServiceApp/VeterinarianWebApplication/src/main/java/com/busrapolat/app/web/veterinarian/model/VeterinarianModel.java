package com.busrapolat.app.web.veterinarian.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class VeterinarianModel {
    private long m_diplomaNo;

    private String m_fullName;

    private LocalDate m_birthDate;

    private LocalDate m_registerDate;

    public long getDiplomaNo()
    {
        return m_diplomaNo;
    }

    public void setDiplomaNo(long diplomaNo)
    {
        m_diplomaNo = diplomaNo;
    }

    public String getFullName()
    {
        return m_fullName;
    }

    public void setFullName(String fullName)
    {
        m_fullName = fullName;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }

    public LocalDate getRegisterDate()
    {
        return m_registerDate;
    }

    public void setRegisterDate(LocalDate registerDate)
    {
        m_registerDate = registerDate;
    }
}
