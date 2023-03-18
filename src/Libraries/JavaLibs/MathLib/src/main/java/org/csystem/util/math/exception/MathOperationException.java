/*----------------------------------------------------------------------
	FILE        : MathOperationException.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 18.03.2023

	MathOperationException class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math.exception;

import org.csystem.util.math.MathOperationStatus;

public class MathOperationException extends IllegalArgumentException {
    private final MathOperationStatus m_mathOperationStatus;

    public MathOperationException(String message)
    {
        this(message, MathOperationStatus.NAN);
    }

    public MathOperationException(String message, MathOperationStatus mathOperationStatus)
    {
        super(message);
        m_mathOperationStatus = mathOperationStatus;
    }

    @Override
    public String getMessage()
    {
        return String.format("Message:%s, Status:%s", super.getMessage(), m_mathOperationStatus);
    }

    public MathOperationStatus getMathOperationStatus()
    {
        return m_mathOperationStatus;
    }
}
