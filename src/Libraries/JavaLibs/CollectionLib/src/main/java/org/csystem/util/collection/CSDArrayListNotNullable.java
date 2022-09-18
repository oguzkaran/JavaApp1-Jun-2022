/*----------------------------------------------------------------
	FILE		: CSDVectorNotNullable.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 18.09.2022

	CSDVectorNotNullable class that represents not nullable
	valued Vector

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CSDArrayListNotNullable<E> extends ArrayList<E> {
    private static <E> void checkAnyNull(Collection<? extends E> collection)
    {
        for (var e : collection)
            checkNull(e);
    }

    private static <E> void checkNull(E e)
    {
        if (e == null)
            throw new IllegalArgumentException("null value not allowed");
    }

    public CSDArrayListNotNullable(int initialCapacity)
    {
        super(initialCapacity);
    }

    public CSDArrayListNotNullable()
    {
    }

    public CSDArrayListNotNullable(Collection<? extends E> collection)
    {
        this(collection.size());
        addAll(collection);
    }

    @Override
    public E set(int index, E element)
    {
        checkNull(element);
        return super.set(index, element);
    }

    @Override
    public boolean add(E e)
    {
        checkNull(e);

        return super.add(e);
    }

    @Override
    public void add(int index, E element)
    {
        checkNull(element);

        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection)
    {
        checkAnyNull(collection);
        return super.addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection)
    {
        checkAnyNull(collection);

        return super.addAll(index, collection);
    }
}
