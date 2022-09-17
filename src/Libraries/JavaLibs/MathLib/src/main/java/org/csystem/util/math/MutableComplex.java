/*----------------------------------------------------------------
	FILE		: MutableComplex.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022
	
	MutableComplex class that represents a "Complex Number"
	
	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math;

public class MutableComplex {
	private double m_real;
	private double m_imag;

	public MutableComplex()
	{
	}

	public MutableComplex(double a)
	{
		this(a, 0);
	}

	public MutableComplex(double a, double b)
	{
		m_real = a;
		m_imag = b;
	}

	public double getReal()
	{
		return m_real;
	}

	public void setReal(double real)
	{
		m_real = real;
	}

	public double getImag()
	{
		return m_imag;
	}

	public void setImag(double imag)
	{
		m_imag = imag;
	}

	public double getLength()
	{
		return ComplexCommonUtil.length(m_real, m_imag);
	}

	public double getNorm()
	{
		return getLength();
	}

	public MutableComplex getConjugate()
	{
		return new MutableComplex(m_real, -m_imag);
	}

	//add methods
	public static MutableComplex add(double value, MutableComplex z)
	{
		return ComplexCommonUtil.add(value, 0, z.m_real, z.m_imag);
	}

	public MutableComplex add(MutableComplex other)
	{
		return ComplexCommonUtil.add(m_real, m_imag, other.m_real, other.m_imag);
	}

	public MutableComplex add(double value)
	{
		return ComplexCommonUtil.add(m_real, m_imag, value, 0);
	}

	//subtract methods
	public static MutableComplex subtract(double value, MutableComplex z)
	{
		return ComplexCommonUtil.subtract(value, 0, z.m_real, z.m_imag);
	}

	public MutableComplex subtract(MutableComplex other)
	{
		return ComplexCommonUtil.subtract(m_real, m_imag, other.m_real, other.m_imag);
	}

	public MutableComplex subtract(double value)
	{
		return ComplexCommonUtil.subtract(m_real, m_imag, value, 0);
	}

	//inc methods
	public void inc(double value)
	{
		m_real += value;
	}

	public void inc()
	{
		inc(1);
	}

	//dec methods
	public void dec(double value)
	{
		inc(-value);
	}

	public void dec()
	{
		dec(1);
	}

	public Complex toComplex()
	{
		return new Complex(m_real, m_imag);
	}

	public String toString()
	{
		return ComplexCommonUtil.toString(m_real, m_imag);
	}
}
