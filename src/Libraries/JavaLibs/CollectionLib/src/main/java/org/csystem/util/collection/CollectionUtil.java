/*----------------------------------------------------------------
	FILE		: CollectionUtil.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 15.01.2023

	Utility class for generic collection operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class CollectionUtil {
    private CollectionUtil()
    {
    }

    public static <T> List<T> toList(Iterable<? extends T> iterable)
    {
        return toList(iterable, false);
    }

    public static <T> List<T> toList(Iterable<? extends T> iterable, boolean parallel)
    {
        return StreamSupport.stream(iterable.spliterator(), parallel).collect(Collectors.toList());
    }

    public static <T, R> List<R> toList(Iterable<? extends T> iterable, Function<? super T, ? extends R> function)
    {
        return toList(iterable, function, false);
    }

    public static <T, R> List<R> toList(Iterable<? extends T> iterable, Function<? super T, ? extends R> function, boolean parallel)
    {
        return StreamSupport.stream(iterable.spliterator(), parallel).map(function).collect(Collectors.toList());
    }

    public static <T, R> Iterable<R> toIterable(Iterable<? extends T> iterable, Function<? super T, ? extends R> function)
    {
        return toIterable(iterable, function, false);
    }

    public static <T, R> Iterable<R> toIterable(Iterable<? extends T> iterable, Function<? super T, ? extends R> function, boolean parallel)
    {
        return toList(iterable, function, parallel);
    }
    //...
}
