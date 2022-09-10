/*----------------------------------------------------------------------
	FILE        : IntGenerator.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 10.09.2022

	Iterable IntGenerator class generates int values

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package org.csystem.util.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class IntGenerator implements Iterable<Integer> {
    private final int m_count;
    private final IIntSupplier m_supplier;

    private IntGenerator(int count, IIntSupplier supplier)
    {
        m_count = count;
        m_supplier = supplier;
    }

    public static IntGenerator of(Random random, int count, int min, int bound)
    {
        return of(count, () -> random.nextInt(bound - min) + min);
    }

    public static IntGenerator of(int count, IIntSupplier supplier)
    {
        return new IntGenerator(count, supplier);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int count;
            @Override
            public boolean hasNext()
            {
                return count + 1 <= m_count;
            }

            @Override
            public Integer next()
            {
                Integer result = null;

                try {
                    if (!hasNext())
                        throw new NoSuchElementException("No such random value");

                    ++count;
                    result = m_supplier.getAsInt();
                }
                catch (Exception ignore) {

                }

                return result;
            }
        };
    }
}
