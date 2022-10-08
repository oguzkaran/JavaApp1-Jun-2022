/*----------------------------------------------------------------------
	FILE        : MutableFraction.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	MutableFraction class that represents fraction in mathematics

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math;

public class MutableFraction implements Comparable<MutableFraction> {
    private int m_a;
    private int m_b;

    private static MutableFraction add(int a1, int b1, int a2, int b2)
    {
        return new MutableFraction(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static MutableFraction subtract(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static MutableFraction multiply(int a1, int b1, int a2, int b2)
    {
        return new MutableFraction(a1 * a2, b1 * b2);
    }

    private static MutableFraction divide(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1, b2, a2);
    }

    private static void check(double a, double b)
    {
        if (b == 0) {
            if (a == 0)
                throw new IllegalArgumentException("Indeterminate");

            throw new IllegalArgumentException("Undefined");
        }
    }

    private void simplify()
    {
        int min = Math.min(Math.abs(m_a), m_b);

        for (int i = min; i > 1; --i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
    }

    private void setValues(int a, int b)
    {
        m_a = a;
        m_b = b;
    }

    private void setSign()
    {
        if (m_b < 0) {
            m_a = -m_a;
            m_b = -m_b;
        }
    }

    private void set(int a, int b)
    {
        if (a == 0) {
            m_a = 0;
            m_b = 1;
            return;
        }

        setValues(a, b);
        setSign();
        simplify();
    }

    public MutableFraction()
    {
        m_b = 1;
    }

    public MutableFraction(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public MutableFraction(int a, int b)
    {
        check(a, b);
        set(a, b);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int a)
    {
        set(a, m_b);
    }

    public int getDenominator()
    {
        return m_b;
    }

    public void setDenominator(int b)
    {
        check(m_a, b);
        set(m_a, b);
    }

    public double getRealValue()
    {
        return (double)m_a / m_b;
    }

    //add methods
    public static MutableFraction add(int val, MutableFraction f)
    {
        return add(val, 1, f.m_a, f.m_b);
    }

    public MutableFraction add(MutableFraction other)
    {
        return add(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    //subtract methods
    public static MutableFraction subtract(int val, MutableFraction f)
    {
        return subtract(val, 1, f.m_a, f.m_b);
    }

    public MutableFraction subtract(MutableFraction other)
    {
        return subtract(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction subtract(int val)
    {
        return subtract(m_a, m_b, val, 1);
    }

    //multiply methods
    public static MutableFraction multiply(int val, MutableFraction f)
    {
        return multiply(val, 1, f.m_a, f.m_b);
    }

    public MutableFraction multiply(MutableFraction other)
    {
        return multiply(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction multiply(int val)
    {
        return multiply(m_a, m_b, val, 1);
    }

    //divide methods
    public static MutableFraction divide(int val, MutableFraction f)
    {
        return divide(val, 1, f.m_a, f.m_b);
    }

    public MutableFraction divide(MutableFraction other)
    {
        return divide(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction divide(int val)
    {
        return divide(m_a, m_b, val, 1);
    }

    public void inc()
    {
        m_a += m_b;
    }

    public void dec()
    {
        m_a -= m_b;
    }

    @Override
    public String toString()
    {
        return String.format("%d%s", m_a, m_b != 1 ? " / " + m_b + " = " + getRealValue() : "");
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof MutableFraction))
            return false;

        var f = (MutableFraction)other;

        return m_a == f.m_a && m_b == f.m_b;
    }

    @Override
    public int compareTo(MutableFraction other)
    {
        return m_a * other.m_b - other.m_a * m_b;
    }
}
