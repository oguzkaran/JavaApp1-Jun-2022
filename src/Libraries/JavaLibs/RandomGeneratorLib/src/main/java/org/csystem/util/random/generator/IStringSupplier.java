package org.csystem.util.random.generator;

@FunctionalInterface
public interface IStringSupplier {
    String getAsString() throws Exception;
}
