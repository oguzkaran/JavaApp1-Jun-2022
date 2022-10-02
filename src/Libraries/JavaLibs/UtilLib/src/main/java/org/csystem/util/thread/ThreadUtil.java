/*----------------------------------------------------------------------
	FILE        : ThreadUtil.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 01.10.2022

	Utility class for thread operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package org.csystem.util.thread;

public class ThreadUtil {
    public static void sleep(long ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignore) {

        }
    }
}
