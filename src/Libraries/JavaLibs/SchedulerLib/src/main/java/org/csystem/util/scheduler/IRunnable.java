/*----------------------------------------------------------------------
	FILE        : IRunnable.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 20.08.2022

	IRunnable interface that is useful for checked exceptions

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.scheduler;

public interface IRunnable {
    void run() throws Exception;
}
