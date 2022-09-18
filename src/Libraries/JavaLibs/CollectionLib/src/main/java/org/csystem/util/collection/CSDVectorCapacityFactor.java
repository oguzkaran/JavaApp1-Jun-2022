/*----------------------------------------------------------------
	FILE		: CSDVectorCapacityFactor.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 18.09.2022

	CSDVectorNotNullable class that use capacity factor

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.Collection;
import java.util.Vector;

public class CSDVectorCapacityFactor<E> extends Vector<E> {
    public CSDVectorCapacityFactor()
    {
    }

    public CSDVectorCapacityFactor(int initialCapacity)
    {
        super(initialCapacity);
    }

    public CSDVectorCapacityFactor(int initialCapacity, int capacityFactor)
    {
        
    }

    @Override
    public boolean add(E e)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void add(int index, E element)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean addAll(Collection<? extends E> collection)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
