package org.csystem.util.converter;

@FunctionalInterface
public interface IConverter<T, R> {
    R convert(T t) throws Exception;

    default T convertBack(R r) throws Exception
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
