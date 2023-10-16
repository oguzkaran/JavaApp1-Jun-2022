/*----------------------------------------------------------------
	FILE		: Triple.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 25.06.2023

	Triple class that represents triple tuple

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.tuple;

public class Triple<F, S, T> {
    public final F first;
    public final S second;
    public final T third;

    public static <F, S, T> Triple<F, S, T> of(F first, S second, T third)
    {
        return new Triple<>(first, second, third);
    }

    public Triple(F first, S second, T third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String toString()
    {
        return String.format("(%s, %s, %s)", first, second, third);
    }

    //...
}
