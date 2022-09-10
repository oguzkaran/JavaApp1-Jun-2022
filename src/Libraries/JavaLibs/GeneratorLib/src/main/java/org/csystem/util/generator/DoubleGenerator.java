/*----------------------------------------------------------------------
	FILE        : DoubleGenerator.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 10.09.2022

	Iterable DoubleGenerator class generates double values

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package org.csystem.util.generator;

import java.util.Iterator;
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static DoubleGenerator of(int count, IDoubleSupplier supplier)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Iterator<Double> iterator()
    {
       return new Iterator<>() {
           @Override
           public boolean hasNext()
           {
               throw new UnsupportedOperationException("Not implemented yet");
           }

           @Override
           public Double next()
           {
               throw new UnsupportedOperationException("Not implemented yet");
           }
       };
    }
}
