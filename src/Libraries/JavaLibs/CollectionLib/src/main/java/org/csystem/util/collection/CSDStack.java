/*----------------------------------------------------------------
	FILE		: CSDStack.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 24.09.2022

	CSDStack class extends from ArrayList

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CSDStack<E> extends ArrayList<E> {
    public boolean empty()
    {
        return isEmpty();
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();

        return get(size() - 1);
    }

    public E pop()
    {
        if (empty())
            throw new EmptyStackException();

        return remove(size() - 1);
    }

    public E push(E item)
    {
        add(item);

        return item;
    }

    public int search(Object o)
    {
        var index = lastIndexOf(o);

        return index == -1 ? index : size() - index;
    }
}
