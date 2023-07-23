package org.csystem.util.converter;

@FunctionalInterface
public interface IDoubleConverter<R> {
    R convert(double val) throws Exception;

    default double convertBack(R r) throws Exception
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
