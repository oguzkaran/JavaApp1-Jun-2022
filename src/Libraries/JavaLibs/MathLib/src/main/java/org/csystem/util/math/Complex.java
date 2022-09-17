/*----------------------------------------------------------------
	FILE		: Complex.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022
	
	Immutable Complex class that represents a "Complex Number"
	
	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math;

public class Complex {
	private final double m_real;
	private final double m_imag;

	public Complex()
	{
		this(0);
	}

	public Complex(double real)
	{
		this(real, 0);
	}

	public Complex(double real, double imag)
	{
		m_real = real;
		m_imag = imag;
	}

	public double getReal()
	{
		return m_real;
	}

	public double getImag()
	{
		return m_imag;
	}

	public double getLength()
	{
		return ComplexCommonUtil.length(m_real, m_imag);
	}

	public double getNorm()
	{
		return getLength();
	}

	public Complex getConjugate()
	{
		return new Complex(m_real, -m_imag);
	}

	//add methods
	public static Complex add(double value, Complex z)
	{
		return ComplexCommonUtil.toComplex(ComplexCommonUtil.add(value, 0, z.m_real, z.m_imag));
	}

	public Complex add(Complex other)
	{
		return ComplexCommonUtil.toComplex(ComplexCommonUtil.add(m_real, m_imag, other.m_real, other.m_imag));
	}

	public Complex add(double value)
	{
		return ComplexCommonUtil.toComplex(ComplexCommonUtil.add(m_real, m_imag, value, 0));
	}

	//subtract methods
	public static Complex subtract(double value, Complex z)
	{
		return ComplexCommonUtil.toComplex(ComplexCommonUtil.subtract(value, 0, z.m_real, z.m_imag));
	}

	public Complex subtract(Complex other)
	{
		return ComplexCommonUtil.toComplex(ComplexCommonUtil.subtract(m_real, m_imag, other.m_real, other.m_imag));
	}

	public Complex subtract(double value)
	{
		return ComplexCommonUtil.toComplex(ComplexCommonUtil.subtract(m_real, m_imag, value, 0));
	}

	//inc methods
	public Complex inc(double value)
	{
		return add(value);
	}

	public Complex inc()
	{
		return inc(1);
	}

	//dec methods
	public Complex dec(double value)
	{
		return inc(-value);
	}

	public Complex dec()
	{
		return dec(1);
	}

	public MutableComplex toMutableComplex()
	{
		return new MutableComplex(m_real, m_imag);
	}

	@Override
	public String toString()
	{
		return ComplexCommonUtil.toString(m_real, m_imag);
	}

	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Complex))
			return false;

		var z = (Complex)other;

		return m_real == z.m_real && m_imag == z.m_imag;
	}
}
