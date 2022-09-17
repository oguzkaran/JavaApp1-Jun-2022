/*----------------------------------------------------------------
	FILE		: Circle.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	Circle class that represents a Circle in geometry

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.abs;

public class Circle {
    protected static final double DELTA = 0.0001;
    private double m_radius;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        setRadius(radius);
    }

    public double getRadius()
    {
        return m_radius;
    }

    public void setRadius(double r)
    {
        m_radius = Math.abs(r);
    }

    public double getArea()
    {
        return Math.PI * m_radius * m_radius;
    }

    public double getCircumference()
    {
        return 2 * Math.PI * m_radius;
    }

    @Override
    public String toString()
    {
        return String.format("Radius: %f", m_radius);
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Circle))
            return false;

        return abs(m_radius - ((Circle)other).m_radius) < DELTA;
    }
}
