/*------------------------------------------------------------------
	FILE		: DateTimeException.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 10.06.2023

	DateTimeException class

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.util.datetime;

public class DateTimeException extends RuntimeException {
    public DateTimeException(String message)
    {
        this(message, null);
    }

    public DateTimeException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
