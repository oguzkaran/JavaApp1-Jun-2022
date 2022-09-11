/*----------------------------------------------------------------------
	FILE        : DoubleRange.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 11.09.2022

	DoubleRange class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.iterable;

import java.util.Iterator;
import java.util.function.DoubleUnaryOperator;

public class DoubleRange implements Iterable<Double> {
    private final double m_min;
    private final double m_bound;
    private final DoubleUnaryOperator m_doubleUnaryOperator;

    private DoubleRange(double min, double bound, DoubleUnaryOperator doubleUnaryOperator)
    {
        m_min = min;
        m_bound = bound;
        m_doubleUnaryOperator = doubleUnaryOperator;
    }

    public static DoubleRange of(double min, double bound, double step)
    {
        return of(min, bound, val -> val + step);
    }

    public static DoubleRange of(double min, double bound, DoubleUnaryOperator doubleUnaryOperator)
    {
        return new DoubleRange(min, bound, doubleUnaryOperator);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            double value = m_min;

            @Override
            public boolean hasNext()
            {
                return value < m_bound;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new IllegalArgumentException("No such value");

                double result = value;

                value = m_doubleUnaryOperator.applyAsDouble(value);

                return result;
            }
        };
    }
}
