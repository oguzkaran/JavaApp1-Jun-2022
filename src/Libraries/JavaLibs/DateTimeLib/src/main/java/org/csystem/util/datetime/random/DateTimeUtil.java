/*----------------------------------------------------------------------
	FILE        : DateTimeUtil.java
	AUTHOR      : Oğuz Karan, JavaApp1-Jun-2022 group
	LAST UPDATE : 03.09.2022

	DateTimeUtil class for date time operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime.random;

import java.time.LocalDate;
import java.util.Random;

public final class DateTimeUtil {
    private DateTimeUtil()
    {}
    private static final int [] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static LocalDate randomDate(Random r)
    {
        return randomDate(r, LocalDate.now().getYear());
    }

    public static LocalDate randomDate(Random r, int year)
    {
        return randomDate(r, year, year);
    }

    public static LocalDate randomDate(Random r, int minYear, int maxYear)
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int month = r.nextInt(12) + 1;
        int day = r.nextInt(month == 2 && isLeapYear(year) ? 29 : DAYS[month]) + 1;

        return LocalDate.of(year, month, day);
    }

    //...
}
