/*----------------------------------------------------------------
	FILE		: Fraction.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 10.06.2023

	Fraction class that represents fraction

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math;

public class Fraction {
    private int m_a;
    private int m_b;

    private static Fraction add(int a1, int b1, int a2, int b2)
    {
        return new Fraction(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static Fraction subtract(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static Fraction multiply(int a1, int b1, int a2, int b2)
    {
        return new Fraction(a1 * a2, b1 * b2);
    }

    private static Fraction divide(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1, b2, a2);
    }

    private static void check(int a, int b)
    {
        if (b == 0) {
            if (a == 0)
                throw new NumberFormatException("Indeterminate");

            throw new NumberFormatException("Undefined");
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

        m_a = a;
        m_b = b;
        setSign();
        simplify();
    }

    public Fraction()
    {
        m_b = 1;
    }

    public Fraction(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public Fraction(int a, int b)
    {
        check(a, b);
        set(a, b);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int value)
    {
        if (value == m_a)
            return;

        set(value, m_b);
    }

    public int getDenominator()
    {
        return m_b;
    }

    public void setDenominator(int value)
    {
        if (value == m_b)
            return;

        check(m_a, value);
        set(m_a, value);
    }

    public double getRealValue()
    {
        return (double)m_a / m_b;
    }
    public Fraction add(Fraction other)
    {
        return add(m_a, m_b, other.m_a, other.m_b);
    }

    public Fraction add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    public Fraction subtract(Fraction other)
    {
        return subtract(m_a, m_b, other.m_a, other.m_b);
    }

    public Fraction subtract(int val)
    {
        return subtract(m_a, m_b, val, 1);
    }

    public Fraction multiply(Fraction other)
    {
        return multiply(m_a, m_b, other.m_a, other.m_b);
    }

    public Fraction multiply(int val)
    {
        return multiply(m_a, m_b, val, 1);
    }

    public Fraction divide(Fraction other)
    {
        return divide(m_a, m_b, other.m_a, other.m_b);
    }

    public Fraction divide(int val)
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

    public int compareTo(Fraction other)
    {
        return m_a * other.m_b - m_b * other.m_a;
    }

    public String toString()
    {
        return String.format("%d%s", m_a, m_b != 1 ? String.format(" / %d = %f", m_b, getRealValue()) : "");
    }
}
