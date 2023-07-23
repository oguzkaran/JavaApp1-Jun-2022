package org.csystem.util.converter;

@FunctionalInterface
public interface ILongConverter<R> {
    R convert(long val) throws Exception;

    default long convertBack(R r) throws Exception
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
