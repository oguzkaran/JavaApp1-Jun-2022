/*----------------------------------------------------------------
	FILE		: Value.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	Immutable Value that represents Tuple<T>

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.tuple;

public class Value<T> {
    private final T m_value;

    public static <T> Value<T> of(T value)
    {
        return new Value<>(value);
    }

    public Value(T value)
    {
        m_value = value;
    }

    public T getValue()
    {
        return m_value;
    }

    @Override
    public String toString()
    {
        return m_value + "";
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Value && m_value.equals(((Value<T>)other).m_value);
    }
}
