/*----------------------------------------------------------------------
    FILE        : ExceptionUtil.java
    AUTHOR      : Oğuz Karan
    LAST UPDATE : 19.09.2021

    ExceptionUtil class for exception managing

    Copyleft (c) 1993 by C and System Programmers Association (CSD)
    All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.exception;

import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;
import java.util.function.Function;

public final class ExceptionUtil {
    private static <T extends RuntimeException> void throwException(String msg, Class<T> cls, Throwable ex)
    {
        try {
            throw cls.getConstructor(String.class, Throwable.class).newInstance(msg, ex);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new UnsupportedOperationException("Fault for exception class");
        }
    }

    private ExceptionUtil()
    {}

    public static <T extends RuntimeException> void doForRunnable(IRunnable actionCallback, String msg, Class<T> cls)
    {
        try {
            actionCallback.run();
        }
        catch (Throwable ex) {
            throwException(msg, cls, ex);
        }
    }

    public static <T extends RuntimeException> void doForRunnable(IRunnable actionCallback, Consumer<Throwable> consumer, String msg, Class<T> cls)
    {
        try {
            actionCallback.run();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
            throwException(msg, cls, ex);
        }
    }

    public static <T extends RuntimeException, R> R doForSupplier(ISupplier<R> supplier, String msg, Class<T> cls)
    {
        R result = null;

        try {
            result = supplier.get();
        }
        catch (Throwable ex) {
            throwException(msg, cls, ex);
        }

        return result;
    }

    public static <T extends RuntimeException, R> R doForSupplier(ISupplier<R> supplier, Consumer<Throwable>  consumer, String msg, Class<T> cls)
    {
        R result = null;

        try {
            result = supplier.get();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
            throwException(msg, cls, ex);
        }

        return result;
    }

    public static <R> R doForRuntimeException(ISupplier<R> supplier, String msg)
    {
        try {
            return supplier.get();
        }
        catch (Throwable ex) {
            throw new RuntimeException(msg, ex);
        }
    }

    public static void doForRuntimeException(IRunnable actionCallback, String msg)
    {
        try {
            actionCallback.run();
        }
        catch (Throwable ex) {
            throw new RuntimeException(msg, ex);
        }
    }

    public static <R> R subscribe(ISupplier<R> supplier, Function<Throwable, R> function)
    {
        try {
            return supplier.get();
        }
        catch (Throwable ex) {
            return function.apply(ex);
        }
    }

    public static void subscribeRunnable(IRunnable actionCallback, Consumer<Throwable> consumer)
    {
        try {
            actionCallback.run();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
        }
    }

    public static <R> R subscribe(ISupplier<R> supplier, Function<Throwable, R> function, Runnable runnableCompleted)
    {
        try {
            return supplier.get();
        }
        catch (Throwable ex) {
            return function.apply(ex);
        }
        finally {
            runnableCompleted.run();
        }
    }

    public static void subscribeRunnable(IRunnable actionCallback, Consumer<Throwable> consumer, Runnable runnableCompleted)
    {
        try {
            actionCallback.run();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
        }
        finally {
            runnableCompleted.run();
        }
    }

    public static <R> R subscribe(ISupplier<R> supplier, Closeable closeable, Function<Throwable, R> function, Runnable runnableCompleted)
    {
        try (closeable) {
            return supplier.get();
        }
        catch (Throwable ex) {
            return function.apply(ex);
        }
        finally {
            runnableCompleted.run();
        }
    }

    public static void subscribeRunnable(IRunnable actionCallback, Closeable closeable, Consumer<Throwable> consumer, Runnable runnableCompleted)
    {
        try (closeable) {
            actionCallback.run();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
        }
        finally {
            runnableCompleted.run();
        }
    }

    public static <R> R subscribe(ISupplier<R> supplier, Closeable closeable, Function<Throwable, R> function)
    {
        try (closeable) {
            return supplier.get();
        }
        catch (Throwable ex) {
            return function.apply(ex);
        }
    }

    public static void subscribeRunnable(IRunnable actionCallback, Closeable closeable, Consumer<Throwable> consumer)
    {
        try (closeable) {
            actionCallback.run();
        }
        catch (Throwable ex) {
            consumer.accept(ex);
        }
    }
}
