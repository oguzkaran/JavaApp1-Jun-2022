package org.csystem.util.generator;

@FunctionalInterface
public interface IDoubleSupplier {
    double getAsDouble() throws Exception;
}
