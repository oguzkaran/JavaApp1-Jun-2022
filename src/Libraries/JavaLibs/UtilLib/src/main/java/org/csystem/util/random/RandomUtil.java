/*----------------------------------------------------------------------
	FILE        : RandomUtil.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 05.06.2022

	Utility class for random operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.random;

import java.util.Random;

public class RandomUtil {
    private RandomUtil()
    {
    }

    public static int nextInt(Random r, int a, int bound)
    {
        return r.nextInt(bound - a) + a;
    }

    public static double nextDouble(Random r, double a, double bound)
    {
        return r.nextDouble() * (bound - a) + a;
    }
}
