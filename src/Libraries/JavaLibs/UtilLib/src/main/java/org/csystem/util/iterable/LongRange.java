/*----------------------------------------------------------------------
	FILE        : LongRange.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 11.09.2022

	LongRange class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.LongUnaryOperator;

public class LongRange implements Iterable<Long> {
    private final long m_min;
    private final long m_max;
    private final LongUnaryOperator m_longUnaryOperator;

    private LongRange(long min, long max, LongUnaryOperator longUnaryOperator)
    {
        m_min = min;
        m_max = max;
        m_longUnaryOperator = longUnaryOperator;
    }

    public static LongRange of(long min, long bound)
    {
        return of(min, bound, 1);
    }

    public static LongRange of(long min, long bound, long step)
    {
        return ofClosed(min, bound - 1, step);
    }

    public static LongRange ofClosed(long min, long max)
    {
        return ofClosed(min, max, 1);
    }

    public static LongRange ofClosed(long min, long max, long step)
    {
        return ofClosed(min, max, (step <= 1) ? (val -> val + 1) : (val -> val + step));
    }

    public static LongRange of(long min, long bound, LongUnaryOperator longUnaryOperator)
    {
        return ofClosed(min, bound - 1, longUnaryOperator);
    }

    public static LongRange ofClosed(long min, long max, LongUnaryOperator longUnaryOperator)
    {
        return new LongRange(min, max, longUnaryOperator);
    }

    @Override
    public Iterator<Long> iterator()
    {
        return new Iterator<>() {
            long value = m_min;

            @Override
            public boolean hasNext()
            {
                return value <= m_max;
            }

            @Override
            public Long next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such value");

                long result = value;

                value = m_longUnaryOperator.applyAsLong(value);

                return result;
            }
        };
    }
}
