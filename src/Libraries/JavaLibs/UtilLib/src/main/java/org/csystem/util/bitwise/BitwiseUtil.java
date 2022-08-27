/*----------------------------------------------------------------------
	FILE        : BitwiseUtil.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 27.08.2022

	Utility class for bitwise operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.bitwise;

public final class BitwiseUtil {
    private BitwiseUtil()
    {}

    public static int clearBit(int a, int k) // -> [0, 31]
    {
        return a & ~(1 << k);
    }

    public static long clearBit(long a, int k) // -> [0, 63]
    {
        return a & ~(1L << k);
    }

    public static int highestSetBit(int a)
    {
        for (int i = Integer.SIZE - 1; i >= 0; --i)
            if (isSet(a, i))
                return i;

        return -1;
    }

    public static int lowestClearBit(byte a)
    {
        for (int i = 0; i < Byte.SIZE; ++i)
            if (isClear(a, i))
                return i;

        return -1;
    }

    public static int lowestClearBit(short a)
    {
        for (int i = 0; i < Short.SIZE; ++i)
            if (isClear(a, i))
                return i;

        return -1;
    }

    public static int lowestClearBit(int a)
    {
        for (int i = 0; i < Integer.SIZE; ++i)
            if (isClear(a, i))
                return i;

        return -1;
    }

    public static int lowestClearBit(long a)
    {
        for (int i = 0; i < Long.SIZE; ++i)
            if (isClear(a, i))
                return i;

        return -1;
    }

    public static int lowestClearBit(char a)
    {
        for (int i = 0; i < Character.SIZE; ++i)
            if (isClear(a, i))
                return i;

        return -1;
    }

    public static int lowestSetBit(byte a)
    {
        for (int i = 0; i < Byte.SIZE; ++i)
            if (isSet(a, i))
                return i;

        return -1;
    }

    public static int lowestSetBit(short a)
    {
        for (int i = 0; i < Short.SIZE; ++i)
            if (isSet(a, i))
                return i;

        return -1;
    }

    public static int lowestSetBit(int a)
    {
        for (int i = 0; i < Integer.SIZE; ++i)
            if (isSet(a, i))
                return i;

        return -1;
    }

    public static int lowestSetBit(long a)
    {
        for (int i = 0; i < Long.SIZE; ++i)
            if (isSet(a, i))
                return i;

        return -1;
    }

    public static int lowestSetBit(char a)
    {
        for (int i = 0; i < Character.SIZE; ++i)
            if (isSet(a, i))
                return i;

        return -1;
    }

    public static int [] indicesOfSetBits(int a)
    {
        var indices = new int[setBitsCount(a)];
        var idx = 0;

        for (int i = 0; i < Integer.SIZE; ++i)
            if (isSet(a, i))
                indices[idx++] = i;

        return indices;
    }

    public static int [] indicesOfSetBits(long a)
    {
        var indices = new int[setBitsCount(a)];
        var idx = 0;

        for (int i = 0; i < Long.SIZE; ++i)
            if (isSet(a, i))
                indices[idx++] = i;

        return indices;
    }

    public static boolean isClear(int a, int k)
    {
        return !isSet(a, k);
    }

    public static boolean isClear(long a, int k)
    {
        return !isSet(a, k);
    }

    public static boolean isPowerOfTwo(int a)
    {
        return a != 0 && (a & (a - 1)) == 0;
    }

    public static boolean isPowerOfTwo(long a)
    {
        return a != 0 && (a & (a - 1)) == 0;
    }

    public static boolean isSet(int a, int k)
    {
        return (a & 1 << k) != 0;
    }

    public static boolean isSet(long a, int k)
    {
        return (a & 1L << k) != 0;
    }

    public static int setBitsCount(int a)
    {
        var count = 0;

        for (int i = 0; i < Integer.SIZE; ++i)
            if (isSet(a, i))
                ++count;

        return count;
    }

    public static int setBitsCount(long a)
    {
        var count = 0;

        for (int i = 0; i < Long.SIZE; ++i)
            if (isSet(a, i))
                ++count;

        return count;
    }

    public static int setBit(int a, int k) // -> [0, 31]
    {
        return a | 1 << k;
    }

    public static long setBit(long a, int k) // -> [0, 63]
    {
        return a | 1L << k;
    }

    public static int toggleBit(int a, int k) // -> [0, 31]
    {
        return a ^ 1 << k;
    }

    public static long toggleBit(long a, int k) // -> [0, 31]
    {
        return a ^ 1L << k;
    }

    public static String toBitsStr(byte a)
    {
        var bits = new char[Byte.SIZE];

        for (int k = 7; k >= 0; --k)
            bits[7 - k] = (a & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(short a)
    {
        var bits = new char[Short.SIZE];

        for (int k = 15; k >= 0; --k)
            bits[15 - k] = (a & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(int a)
    {
        var bits = new char[Integer.SIZE];

        for (int k = 31; k >= 0; --k)
            bits[31 - k] = isSet(a, k) ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(long a)
    {
        var bits = new char[Long.SIZE];

        for (int k = 63; k >= 0; --k)
            bits[63 - k] = isSet(a, k) ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(char c)
    {
        var bits = new char[Character.SIZE];

        for (int k = 15; k >= 0; --k)
            bits[15 - k] = (c & 1 << k) != 0 ? '1' : '0';

        return String.valueOf(bits);
    }

    public static void writeBits(byte a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(short a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(int a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(long a)
    {
        System.out.println(toBitsStr(a));
    }

    public static void writeBits(char c)
    {
        System.out.println(toBitsStr(c));
    }
}
