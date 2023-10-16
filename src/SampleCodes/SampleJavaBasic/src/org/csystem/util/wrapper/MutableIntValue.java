/*----------------------------------------------------------------
	FILE		: MutableIntValue.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 13.05.2023

	MutableIntValue IntValue class that wraps an int value

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.wrapper;

public final class MutableIntValue {
    private int m_value;

    public static final MutableIntValue ZERO = of(0);
    public static final MutableIntValue ONE = of(1);
    public static final MutableIntValue TWO = of(2);
    public static final MutableIntValue TEN = of(10);

    private MutableIntValue(int value)
    {
        m_value = value;
    }

    public static MutableIntValue of(int value)
    {
        return new MutableIntValue(value);
    }

    public void setValue(int value)
    {
        m_value = value;
    }

    public int getValue()
    {
        return m_value;
    }

    public int compareTo(MutableIntValue other)
    {
        return m_value - other.m_value;
    }

    public MutableIntValue add(int value)
    {
        m_value += value;

        return this;
    }

    public MutableIntValue add(MutableIntValue value)
    {
        add(value.m_value);

        return this;
    }

    public MutableIntValue subtract(int value)
    {
        add(-value);

        return this;
    }

    public MutableIntValue subtract(MutableIntValue value)
    {
        subtract(value.m_value);

        return this;
    }

    public MutableIntValue multiply(int value)
    {
        m_value *= value;

        return this;
    }

    public MutableIntValue multiply(MutableIntValue value)
    {
        multiply(value.m_value);

        return this;
    }


    public MutableIntValue mod(int value)
    {
        m_value %= value;

        return this;
    }

    public MutableIntValue mod(MutableIntValue value)
    {
        mod(value.m_value);

        return this;
    }

    public void inc()
    {
        add(1);
    }

    public void dec()
    {
        subtract(1);
    }

    public String toString()
    {
        return m_value + "";
    }
}
