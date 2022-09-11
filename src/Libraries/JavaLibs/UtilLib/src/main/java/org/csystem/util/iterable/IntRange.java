/*----------------------------------------------------------------------
	FILE        : IntRange.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 11.09.2022

	IntRange class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    private final int m_min;
    private final int m_max;
    private final IntUnaryOperator m_intUnaryOperator;

    private IntRange(int min, int max, IntUnaryOperator intUnaryOperator)
    {
        m_min = min;
        m_max = max;
        m_intUnaryOperator = intUnaryOperator;
    }

    public static IntRange of(int min, int bound)
    {
        return of(min, bound, 1);
    }

    public static IntRange of(int min, int bound, int step)
    {
        return ofClosed(min, bound - 1, step);
    }

    public static IntRange ofClosed(int min, int max)
    {
        return ofClosed(min, max, 1);
    }

    public static IntRange ofClosed(int min, int max, int step)
    {
        return ofClosed(min, max, (step <= 1) ? (val -> val + 1) : (val -> val + step));
    }

    public static IntRange of(int min, int bound, IntUnaryOperator intUnaryOperator)
    {
        return ofClosed(min, bound - 1, intUnaryOperator);
    }

    public static IntRange ofClosed(int min, int max, IntUnaryOperator intUnaryOperator)
    {
        return new IntRange(min, max, intUnaryOperator);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int value = m_min;

            @Override
            public boolean hasNext()
            {
                return value <= m_max;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such value");

                int result = value;

                value = m_intUnaryOperator.applyAsInt(value);

                return result;
            }
        };
    }
}
