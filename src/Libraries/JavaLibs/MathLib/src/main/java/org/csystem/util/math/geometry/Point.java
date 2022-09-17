/*----------------------------------------------------------------
	FILE		: Point.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022
	
	Immutable Point class that represents 2(two) dimensional point
	
	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class Point {
	private final double m_x;
	private final double m_y;

	public Point()
	{
		this(0);
	}

	public Point(double x)
	{
	 	this(x, 0);
	}

	public Point(double x, double y)
	{
		 m_x = x;
		 m_y = y;
	}

	public double getX()
	{
		return m_x;
	}

	public double getY()
	{
		return m_y;
	}

	public double distance()
	{
		return distance(0, 0);
	}

	public double distance(Point other)
	{
		return distance(other.m_x, other.m_y);
	}

	public double distance(double x, double y)
	{
		return PointCommonUtil.distance(m_x, m_y, x, y);
	}

	public MutablePoint toMutablePoint()
	{
		return new MutablePoint(m_x, m_y);
	}

	public String toString()
	{
		return PointCommonUtil.toString(m_x, m_y);
	}
}
