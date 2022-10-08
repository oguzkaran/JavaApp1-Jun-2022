/*----------------------------------------------------------------
	FILE		: MutablePoint.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022
	
	MutablePoint class that represents 2(two) dimensional point
	
	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class MutablePoint {
	private double m_x;

	private double m_y;

	public MutablePoint()
	{
	}

	public MutablePoint(double x)
	{
	 	this(x, 0);
	}

	public MutablePoint(double x, double y)
	{
	 	m_x = x;
	 	m_y = y;
	}

	public double getX()
	{
		return m_x;
	}

	public void setX(double x)
	{
		m_x = x;
	}

	public double getY()
	{
		return m_y;
	}

	public void setY(double y)
	{
		m_y = y;
	}

	public double distance()
	{
	 	return distance(0, 0);
	}

 	public double distance(MutablePoint other)
	{
	 	return distance(other.m_x, other.m_y);
	}
	 
 	public double distance(double x, double y)
	{
		return PointCommonUtil.distance(m_x, m_y, x, y);
	}

 	public void offset(double dxy)
	{
	 	offset(dxy, dxy);
	}

 	public void offset(double dx, double dy)
 	{
 		m_x += dx;
 		m_y += dy;
 	}

	public Point toPoint()
	{
		return new Point(m_x, m_y);
	}

	@Override
 	public String toString()
	{
		return PointCommonUtil.toString(m_x, m_y);
	}

	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof MutablePoint))
			return false;

		var p = (MutablePoint)other;

		return m_x == p.m_x && m_y == p.m_y;
	}
}
