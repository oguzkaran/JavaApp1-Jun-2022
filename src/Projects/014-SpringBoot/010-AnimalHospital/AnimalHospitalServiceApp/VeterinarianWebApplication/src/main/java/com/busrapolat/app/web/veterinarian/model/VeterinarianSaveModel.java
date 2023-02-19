package com.busrapolat.app.web.veterinarian.model;

import java.time.LocalDate;

public class VeterinarianSaveModel {
    private long m_diplomaNo;
    private String m_citizenId;
    private String m_firstName;
    private String m_middleName;
    private String m_lastName;
    private LocalDate m_birthDate;

    public long getDiplomaNo()
    {
        return m_diplomaNo;
    }

    public void setDiplomaNo(long diplomaNo)
    {
        m_diplomaNo = diplomaNo;
    }

    public String getCitizenId()
    {
        return m_citizenId;
    }

    public void setCitizenId(String citizenId)
    {
        m_citizenId = citizenId;
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public String getMiddleName()
    {
        return m_middleName;
    }

    public void setMiddleName(String middleName)
    {
        m_middleName = middleName;
    }

    public String getLastName()
    {
        return m_lastName;
    }

    public void setLastName(String lastName)
    {
        m_lastName = lastName;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }
}
