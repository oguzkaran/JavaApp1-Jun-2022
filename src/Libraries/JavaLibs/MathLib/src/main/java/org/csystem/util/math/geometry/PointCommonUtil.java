/*----------------------------------------------------------------
	FILE		: PointCommonUtil.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	Utility PointCommonUtil class for common Point operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class PointCommonUtil {
    private PointCommonUtil()
    {}

    static double distance(double x1, double y1, double x2, double y2)
    {
        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }

    static String toString(double x, double y)
    {
        return String.format("(%f, %f)", x, y);
    }
    //...
}
