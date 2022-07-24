package org.csystem.util.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BirthDateInfo {
    private final LocalDate m_birthDate;

    public BirthDateInfo(int day, int month, int year)
    {
        //...
        m_birthDate = LocalDate.of(year, month, day);
    }

    public int getDay()
    {
        return m_birthDate.getDayOfMonth();
    }

    public int getMonthValue()
    {
        return m_birthDate.getMonthValue();
    }

    public int getYear()
    {
        return m_birthDate.getYear();
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    public BirthDateStatus getBirthDateStatus()
    {
        var today = LocalDate.now();
        var birthDay = m_birthDate.withYear(today.getYear());

        var status = BirthDateStatus.SAME;

        if (birthDay.isAfter(today))
            status = BirthDateStatus.AFTER;
        else if (birthDay.isBefore(today))
            status = BirthDateStatus.BEFORE;

        return status;
    }
}
