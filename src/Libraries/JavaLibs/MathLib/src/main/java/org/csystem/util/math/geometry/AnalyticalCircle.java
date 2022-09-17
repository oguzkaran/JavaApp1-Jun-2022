/*----------------------------------------------------------------
	FILE		: AnalyticalCircle.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	AnalyticalCircle class that represents a Circle in cartesian
	coordinates

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.abs;

public class AnalyticalCircle extends Circle {
    private final MutablePoint m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(double r)
    {
        this(r, 0, 0);
    }

    public AnalyticalCircle(MutablePoint center)
    {
        this(0, center);
    }

    public AnalyticalCircle(double r, MutablePoint center)
    {
        this(r, center.getY(), center.getY());
    }

    public AnalyticalCircle(double x, double y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(double r, double x, double y)
    {
        super(r);
        m_center = new MutablePoint(x, y);
    }

    public double getX()
    {
        return m_center.getX();
    }

    public double getY()
    {
        return m_center.getY();
    }

    public void setX(double x)
    {
        m_center.setX(x);
    }

    public void setY(double y)
    {
        m_center.setY(y);
    }

    public void setCenter(double x, double y)
    {
        setX(x);
        setY(y);
    }

    public void setCenter(MutablePoint center)
    {
        setCenter(center.getX(), center.getY());
    }

    public void offset(double dx, double dy)
    {
        m_center.offset(dx, dy);
    }

    public void offset(double dxy)
    {
        offset(dxy, dxy);
    }

    public double centerDistance(AnalyticalCircle other)
    {
        return m_center.distance(other.m_center);
    }

    public boolean intersects(AnalyticalCircle other)
    {
        //TODO:
        return true;
    }

    public boolean isInside(double x, double y)
    {
        //TODO:
        return true;
    }


    public boolean isTangent(Line line)
    {
        //TODO:
        return true;
    }

    @Override
    public String toString()
    {
        return String.format("%s, Point: %s", super.toString(), m_center);
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof AnalyticalCircle))
            return false;

        var ac = ((AnalyticalCircle)other);

        return super.equals(ac) && abs(m_center.getX() - ac.m_center.getX()) < DELTA
                && abs(m_center.getY() - ac.m_center.getY()) < DELTA;
    }
}
