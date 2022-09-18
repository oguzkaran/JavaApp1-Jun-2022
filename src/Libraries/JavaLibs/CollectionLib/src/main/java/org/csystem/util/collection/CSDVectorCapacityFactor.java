/*----------------------------------------------------------------
	FILE		: CSDVectorCapacityFactor.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 18.09.2022

	CSDVectorCapacityFactor class that use capacity factor

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.Collection;
import java.util.Vector;

public class CSDVectorCapacityFactor<E> extends Vector<E> {
    private final double m_capacityFactor;

    private void configureCapacityIncrement()
    {
        int curCapacity = capacity();

        capacityIncrement = (int)Math.floor(m_capacityFactor * curCapacity) - curCapacity;
    }

    public CSDVectorCapacityFactor()
    {
        this(10);
    }

    public CSDVectorCapacityFactor(double capacityFactor)
    {
        this(10, capacityFactor);
    }

    public CSDVectorCapacityFactor(int initialCapacity)
    {
        this(initialCapacity, 2);
    }

    public CSDVectorCapacityFactor(int initialCapacity, double capacityFactor)
    {
        super(initialCapacity);
        m_capacityFactor = capacityFactor;
        configureCapacityIncrement();
    }

    public CSDVectorCapacityFactor(Collection<? extends E> collection, double capacityFactor)
    {
        super(collection);
        m_capacityFactor = capacityFactor;
        configureCapacityIncrement();
    }

    @Override
    public synchronized void addElement(E obj)
    {
        configureCapacityIncrement();
        super.addElement(obj);
    }

    @Override
    public synchronized boolean add(E e)
    {
        configureCapacityIncrement();

        return super.add(e);
    }

    @Override
    public void add(int index, E element)
    {
        configureCapacityIncrement();

        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        configureCapacityIncrement();

        return super.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends E> c)
    {
        configureCapacityIncrement();

        return super.addAll(index, c);
    }
}
