/*----------------------------------------------------------------------
    FILE        : IRunnable.java
    AUTHOR      : Oğuz Karan
    LAST UPDATE : 22.01.2023

    IRunnable functional interface

    Copyleft (c) 1993 by C and System Programmers Association (CSD)
    All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.exception;

@FunctionalInterface
public interface IRunnable {
    void run() throws Exception;
}
