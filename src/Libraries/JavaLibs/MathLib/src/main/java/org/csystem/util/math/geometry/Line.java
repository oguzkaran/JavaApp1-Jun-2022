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

    //...
}
