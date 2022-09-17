/*----------------------------------------------------------------
	FILE		: ComplexCommonUtil.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	Utility ComplexCommonUtil class for common Complex number operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math;

import static java.lang.Math.sqrt;

class ComplexCommonUtil {
    private ComplexCommonUtil()
    {}

    static MutableComplex add(double a1, double b1, double a2, double b2)
    {
        return new MutableComplex(a1 + a2, b1 + b2);
    }

    static MutableComplex subtract(double a1, double b1, double a2, double b2)
    {
        return add(a1, b1, -a2, -b2);
    }

    //...

    static double length(double real, double imag)
    {
        return sqrt(real * real + imag * imag);
    }

    static Complex toComplex(MutableComplex mc)
    {
        return new Complex(mc.getReal(), mc.getImag());
    }

    static String toString(double real, double imag)
    {
        return String.format("(%f, %f)", real, imag);
    }
    //...
}
