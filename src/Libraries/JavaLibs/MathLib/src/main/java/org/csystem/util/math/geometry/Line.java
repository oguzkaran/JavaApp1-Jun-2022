/*----------------------------------------------------------------
	FILE		: Line.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	Immutable Line class that represents a line in Cartesian Plane

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class Line {
    public final MutablePoint m_p1;
    public final MutablePoint m_p2;

    public Line(double x1, double y1, double x2, double y2)
    {
        m_p1 = new MutablePoint(x1, y1);
        m_p2 = new MutablePoint(x2, y2);
    }

    public double getX1()
    {
        return m_p1.getX();
    }

    public void setX1(double x)
    {
        m_p1.setX(x);
    }

    public double getY1()
    {
        return m_p1.getY();
    }

    public void setY1(double y)
    {
        m_p1.setY(y);
    }

    public double getX2()
    {
        return m_p2.getX();
    }

    public void setX2(double x)
    {
        m_p2.setX(x);
    }

    public double getY2()
    {
        return m_p2.getY();
    }

    public void setY2(double y)
    {
        m_p2.setY(y);
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s", m_p1, m_p2);
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Line))
            return false;

        var line = (Line)other;

        return m_p1.equals(line.m_p1) && m_p2.equals(line.m_p2);
    }
}
