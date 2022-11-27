/*----------------------------------------------------------------------
	FILE        : DataServiceException.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 27.11.2022

	DataServiceException class which can wrap the exception in service

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.data.service;

public class DataServiceException extends RuntimeException {
    public DataServiceException(String message)
    {
        this(message, null);
    }

    public DataServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        var cause = getCause();

        return String.format("Message: %s %s", super.getMessage(), cause != null ? ", Cause Message:" + cause.getMessage() : "");
    }
}
