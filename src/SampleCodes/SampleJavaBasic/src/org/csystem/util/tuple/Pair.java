/*----------------------------------------------------------------
	FILE		: Pair.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 25.06.2023

	Pair class that represents pair tuple

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.tuple;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public static <F, S> Pair<F, S> of(F first, S second)
    {
        return new Pair<>(first, second);
    }

    public Pair(F first, S second)
    {
        this.first = first;
        this.second = second;
    }

    public String toString()
    {
        return String.format("(%s, %s)", first, second);
    }

    //...
}
