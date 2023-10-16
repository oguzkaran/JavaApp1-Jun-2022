/*----------------------------------------------------------------
	FILE		: Complex.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 12.03.2023

	Complex class that represents complex number

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math;

import static java.lang.Math.sqrt;

public class Complex {
	private double m_real;
	private double m_imaginary;
	
	private static Complex add(double re1, double im1, double re2, double im2)
	{
		return new Complex(re1 + re2, im1 + im2);
	}
	
	private static Complex subtract(double re1, double im1, double re2, double im2)
	{
		return add(re1, im1, -re2, -im2);
	}
	
	private static Complex multiply(double re1, double im1, double re2, double im2)
	{		
		return new Complex(re1 * re2 - im1 * im2, re1 * im2 + re2 * im1);
	}
	
	private static Complex divide(double re1, double im1, double re2, double im2)
	{			
		Complex z = multiply(re1, im1, re2, -im2);
		double divider = re1 * re1 + im1 * im2;
		
		z.m_real /= divider;
		z.m_imaginary /= divider;
		
		return z;
	}
	
	public Complex()
	{		
	}
	
	public Complex(double real)
	{
		m_real = real;
	}
	
	public Complex(double real, double imaginary)
	{
		m_real = real;
		m_imaginary = imaginary;
	}

	public double getReal()
	{
		return m_real;
	}

	public void setReal(double real)
	{
		m_real = real;
	}

	public double getImaginary()
	{
		return m_imaginary;
	}

	public void setImaginary(double imaginary)
	{
		m_imaginary = imaginary;
	}

	public double getLength()
	{
		return sqrt(m_real * m_real + m_imaginary * m_imaginary);
	}
	
	public double getNorm()
	{
		return getLength();
	}
	
	public Complex getConjugate()
	{
		return new Complex(m_real, -m_imaginary);
	}
	
	public static Complex add(double val, Complex z)
	{
		return add(val, 0, z.m_real, z.m_imaginary);
	}
	
	public Complex add(Complex other)
	{
		return add(m_real, m_imaginary, other.m_real, other.m_imaginary);
	}
	
	public Complex add(double val)
	{
		return add(m_real, m_imaginary, val, 0);
	}
	
	public static Complex subtract(double val, Complex z)
	{
		return subtract(val, 0, z.m_real, z.m_imaginary);
	}
	
	public Complex subtract(Complex other)
	{
		return subtract(m_real, m_imaginary, other.m_real, other.m_imaginary);
	}
	
	public Complex subtract(double val)
	{
		return subtract(m_real, m_imaginary, val, 0);
	}	
	
	public static Complex multiply(double val, Complex z)
	{
		return multiply(val, 0, z.m_real, z.m_imaginary);
	}
	
	public Complex multiply(Complex other)
	{
		return multiply(m_real, m_imaginary, other.m_real, other.m_imaginary);
	}
	
	public Complex multiply(double val)
	{
		return multiply(m_real, m_imaginary, val, 0);
	}

	public static Complex divide(double val, Complex z)
	{
		return divide(val, 0, z.m_real, z.m_imaginary);
	}
	
	public Complex divide(Complex other)
	{
		return divide(m_real, m_imaginary, other.m_real, other.m_imaginary);
	}
	
	public Complex divide(double val)
	{
		return divide(m_real, m_imaginary, val, 0);
	}
	
	public String toString()
	{
		return String.format("(%f, %f)", m_real, m_imaginary);
	}
}
