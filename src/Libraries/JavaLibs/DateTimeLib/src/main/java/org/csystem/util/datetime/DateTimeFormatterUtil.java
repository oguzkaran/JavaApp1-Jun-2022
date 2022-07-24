/*----------------------------------------------------------------------
	FILE        : DateTimeFormatterUtil.java
	AUTHOR      : Oğuz Karan, JavaApp1-Jun-2022 group
	LAST UPDATE : 24.07.2022

	Utility class for datetime operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.time.format.DateTimeFormatter;

public final class DateTimeFormatterUtil {
    private DateTimeFormatterUtil()
    {}

    public static DateTimeFormatter DATE_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter DATE_DOT_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static DateTimeFormatter DATE_HYPHEN_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static DateTimeFormatter DATETIME_SEC_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
    public static DateTimeFormatter DATETIME_SEC_A_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
    public static DateTimeFormatter DATETIME_DOT_SEC_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm:ss");
    public static DateTimeFormatter DATETIME_HYPHEN_SEC_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy kk:mm:ss");

    public static DateTimeFormatter DATETIME_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm");
    public static DateTimeFormatter DATETIME_DOT_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");
    public static DateTimeFormatter DATETIME_HYPHEN_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy kk:mm");

    public static DateTimeFormatter TIME = DateTimeFormatter.ofPattern("kk:mm");
    public static DateTimeFormatter TIME_SEC = DateTimeFormatter.ofPattern("kk:mm:ss");
    //...
}
