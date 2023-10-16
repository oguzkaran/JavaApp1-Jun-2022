/*----------------------------------------------------------------
	FILE		: Circle.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 10.06.2023

	Circle class that represents a circle

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class Circle {
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

    public void setRadius(double radius)
    {
        if (radius < 0)
            throw new IllegalArgumentException("Radius can not be negative");

        m_radius = radius;
    }

    public double getArea()
    {
        return Math.PI * m_radius * m_radius;
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * m_radius;
    }

    public String toString()
    {
        return String.format("Radius: %f, Area: %f, Perimeter: %f", m_radius, getArea(), getPerimeter());
    }
}
