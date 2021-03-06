package org.csystem.util.datetime;

public class BirthDateInfo {
    private static final double DIVIDER_FOR_AGE = 1000. * 60 * 60 * 24 * 365;
    private final DateTime m_birthDate;

    public BirthDateInfo(int day, int month, int year)
    {
        //...
        m_birthDate = DateTime.of(day, month, year);
    }

    public int getDay()
    {
        return m_birthDate.getDay();
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
        var today = DateTime.today();

        return (today.getTimeInMillis() - m_birthDate.getTimeInMillis()) / DIVIDER_FOR_AGE;
    }

    public BirthDateStatus getBirthDateStatus()
    {
        var today = DateTime.today();
        var birthDay = m_birthDate.withYear(today.getYear());

        var status = BirthDateStatus.SAME;

        if (birthDay.isAfter(today))
            status = BirthDateStatus.AFTER;
        else if (birthDay.isBefore(today))
            status = BirthDateStatus.BEFORE;

        return status;
    }
}
