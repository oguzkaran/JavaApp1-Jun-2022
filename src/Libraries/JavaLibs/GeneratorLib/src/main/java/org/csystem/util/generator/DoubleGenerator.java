/*----------------------------------------------------------------------
	FILE        : DoubleGenerator.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 11.09.2022

	Iterable DoubleGenerator class generates double values

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class DoubleGenerator implements Iterable<Double> {
    private final int m_count;
    private final  IDoubleSupplier m_supplier;

    private DoubleGenerator(int count, IDoubleSupplier supplier)
    {
        m_count = count;
        m_supplier = supplier;
    }

    public static DoubleGenerator of(Random random, int count, double min, double bound)
    {
        return of(count, () -> random.nextDouble() * (bound - min) + min);
    }

    public static DoubleGenerator of(int count, IDoubleSupplier supplier)
    {
        return new DoubleGenerator(count, supplier);
    }

    @Override
    public Iterator<Double> iterator()
    {
       return new Iterator<>() {
           int count;
           @Override
           public boolean hasNext()
           {
                return count + 1 < m_count;
           }

           @Override
           public Double next()
           {
                if (!hasNext())
                    throw new NoSuchElementException("No such random value");

                Double result = null;

                try {
                    ++count;
                    result = m_supplier.getAsDouble();
                }
                catch (Exception ignore) {

                }

                return result;
           }
       };
    }
}
