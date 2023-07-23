package org.csystem.util.converter;

@FunctionalInterface
public interface IIntConverter<R> {
    R convert(int val) throws Exception;

    default int convertBack(R r) throws Exception
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
