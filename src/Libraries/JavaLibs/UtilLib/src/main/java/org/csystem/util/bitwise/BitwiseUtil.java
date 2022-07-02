/*----------------------------------------------------------------------
	FILE        : BitwiseUtil.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 02.07.2022

	Utility class for bitwise operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.bitwise;

public final class BitwiseUtil {
    private static void writeBits(String bitStr, int bitsLength)
    {
        var lengthsOfZeros = bitsLength - bitStr.length();

        System.out.println(lengthsOfZeros != 0 ? String.format("%0" + lengthsOfZeros + "d%s", 0, bitStr) : bitStr);
    }

    private BitwiseUtil()
    {}

    public static void writeBits(int a)
    {
        writeBits(Integer.toBinaryString(a), Integer.SIZE);
    }

    public static void writeBits(long a)
    {
        writeBits(Long.toBinaryString(a), Long.SIZE);
    }

}
