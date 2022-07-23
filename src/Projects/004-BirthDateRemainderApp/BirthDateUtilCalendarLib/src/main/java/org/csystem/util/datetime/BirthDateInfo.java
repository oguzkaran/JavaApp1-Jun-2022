package org.csystem.util.datetime;

import java.util.Calendar;

import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class BirthDateInfo {
    private static final double ms_dividerForAge = 1000. * 60 * 60 * 24 * 365;
    private final Calendar m_birthDate;

    public BirthDateInfo(int day, int month, int year)
    {
        //...
        m_birthDate = new GregorianCalendar(year, month - 1, day);
    }

    public int getDay()
    {
        return m_birthDate.get(DAY_OF_MONTH);
    }

    public int getMonthValue()
    {
        return m_birthDate.get(MONTH) + 1;
    }

    public int getYear()
    {
        return m_birthDate.get(YEAR);
    }

    public double getAge()
    {
        var today = new GregorianCalendar();

        return (today.getTimeInMillis() - m_birthDate.getTimeInMillis()) / ms_dividerForAge;
    }

    public BirthDateStatus getBirthDateStatus()
    {
        var today = new GregorianCalendar();

        today = new GregorianCalendar(today.get(YEAR), today.get(MONTH), today.get(DAY_OF_MONTH));
        var birthDay = new GregorianCalendar(today.get(YEAR), m_birthDate.get(MONTH), m_birthDate.get(DAY_OF_MONTH));

        var status = BirthDateStatus.SAME;

        if (birthDay.after(today))
            status = BirthDateStatus.AFTER;
        else if (birthDay.before(today))
            status = BirthDateStatus.BEFORE;

        return status;
    }
}
