/*----------------------------------------------------------------
	FILE		: Triple.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	Immutable Value that represents Tuple<T1, T2, T3>

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.tuple;

public class Triple<F, S, T> {
    private final F m_first;
    private final S m_second;
    private final T m_third;

    public static <F, S, T> Triple<F, S, T> of(F first, S second, T third)
    {
        return new Triple<>(first, second, third);
    }

    public Triple(F first, S second, T third)
    {
        m_first = first;
        m_second = second;
        m_third = third;
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    public T getThird()
    {
        return m_third;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s, %s)", m_first, m_second, m_third);
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Triple))
            return  false;

        var t = (Triple<F, S, T>)other;

        return m_first.equals(t.m_first) &&  m_second.equals(t.m_second) && m_third.equals(t.m_third);
    }
}
