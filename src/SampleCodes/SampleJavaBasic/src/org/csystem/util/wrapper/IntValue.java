/*----------------------------------------------------------------
	FILE		: IntValue.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 30.04.2023

	Immutable IntValue class that wraps an int value by using cache
	for values in [-128, 127] interval

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.wrapper;

public final class IntValue {
    private static final int CACHE_MIN = -128;
    private static final int CACHE_MAX = 127;
    private static final IntValue [] CACHE = new IntValue[CACHE_MAX - CACHE_MIN + 1];
    private final int m_value;

    public static final IntValue ZERO = of(0);
    public static final IntValue ONE = of(1);
    public static final IntValue TWO = of(2);
    public static final IntValue TEN = of(10);

    private IntValue(int value)
    {
        m_value = value;
    }

    public static IntValue of(int value)
    {
        if (value < CACHE_MIN || CACHE_MAX < value)
            return new IntValue(value);

        int idx = value + 128;

        if (CACHE[idx] == null)
            CACHE[idx] = new IntValue(value);

        return CACHE[idx];
    }

    public int getValue()
    {
        return m_value;
    }

    public int compareTo(IntValue other)
    {
        return m_value - other.m_value;
    }

    public IntValue add(int value)
    {
        return of(m_value + value);
    }

    public IntValue add(IntValue value)
    {
        return add(value.m_value);
    }

    public IntValue subtract(int value)
    {
        return add(-value);
    }

    public IntValue subtract(IntValue value)
    {
        return subtract(value.m_value);
    }

    public IntValue multiply(int value)
    {
        return of(m_value * value);
    }

    public IntValue multiply(IntValue value)
    {
        return multiply(value.m_value);
    }

    public IntValue divide(int value)
    {
        return of(m_value / value);
    }

    public IntValue divide(IntValue value)
    {
        return divide(value.m_value);
    }

    public IntValue [] divideAndRemainder(int value)
    {
        IntValue [] result = new IntValue[2];

        result[0] = divide(value);
        result[1] = mod(value);

        return result;
    }

    public IntValue [] divideAndRemainder(IntValue value)
    {
        return divideAndRemainder(value.m_value);
    }

    public IntValue mod(int value)
    {
        return of(m_value % value);
    }

    public IntValue mod(IntValue value)
    {
        return mod(value.m_value);
    }

    public IntValue inc()
    {
        return add(1);
    }

    public IntValue dec()
    {
        return subtract(1);
    }

    public String toString()
    {
        return m_value + "";
    }
}
