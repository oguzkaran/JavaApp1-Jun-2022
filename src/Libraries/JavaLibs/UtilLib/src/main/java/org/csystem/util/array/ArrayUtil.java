/*----------------------------------------------------------------------
	FILE        : ArrayUtil.java
	AUTHOR      : JavaApp1-Jun-2022 Group
	LAST UPDATE : 09.10.2022

	Utility class for array operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.array;

import org.csystem.util.iterable.IntRange;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public final class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k] > a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static <T extends Comparable<T>> void bubbleSortAscending(T [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k].compareTo(a[k + 1]) > 0)
                    swap(a, k, k + 1);
    }

    private static <T> void bubbleSortAscending(T [] a, Comparator<T> comparator)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (comparator.compare(a[k], a[k + 1]) > 0)
                    swap(a, k, k + 1);
    }

    private static <T extends Comparable<T>> void bubbleSortDescending(T [] a)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (a[k].compareTo(a[k + 1]) < 0)
                    swap(a, k, k + 1);
    }

    private static <T> void bubbleSortDescending(T [] a, Comparator<T> comparator)
    {
        for (var i = 0; i < a.length - 1; ++i)
            for (var k = 0; k < a.length - 1 - i; ++k)
                if (comparator.compare(a[k], a[k + 1]) < 0)
                    swap(a, k, k + 1);
    }


    private static void selectionSortAscending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i) {
            var min = a[i];
            var minIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        for (var i = 0; i < a.length - 1; ++i) {
            var max = a[i];
            var maxIndex = i;

            for (var k = i + 1; k < a.length; ++k)
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {
    }

    public static void addBy(int []a, int val)
    {
        for (var i = 0; i < a.length; ++i)
            a[i] += val;
    }

    public double average(int...a)
    {
        return sum(a) / (double)a.length;
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a, boolean desc)
    {
        if (desc)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static <T extends Comparable<T>> void bubbleSort(T [] a)
    {
        bubbleSort(a, false);
    }

    public static <T extends Comparable<T>> void bubbleSort(T [] a, boolean desc)
    {
        if (desc)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static <T> void bubbleSort(T [] a, Comparator<T> comparator)
    {
        bubbleSort(a, comparator, false);
    }

    public static <T> void bubbleSort(T [] a, Comparator<T> comparator, boolean desc)
    {
        if (desc)
            bubbleSortDescending(a, comparator);
        else
            bubbleSortAscending(a, comparator);
    }

    public static void fillRandomArray(int [] a, int min, int max)
    {
        fillRandomArray(new Random(), a, min, max);
    }

    public static void fillRandomArray(Random r, int [] a, int min, int max)
    {
        IntStream.range(0, a.length).forEach(i -> a[i] = r.nextInt(max - min + 1) + min);
    }

    public static int [] getHistogramData(int [] a, int n) //[0, n]
    {
        var counts = new int[n + 1];

        for (var val : a)
            ++counts[val];

        return counts;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max]
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int [] getRandomArray(Random r, int n, int min, int max) //[min, max]
    {
        var a = new int[n];

        fillRandomArray(r, a, min, max);

        return a;
    }

    public static int [][] getRandomMatrix(int m, int n, int min, int max) //[min, max]
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int [][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max]
    {
        var a = new int[m][];

        for (var i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max) //[min, max]
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max) //[min, max]
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static boolean isMatrix(int [][] a)
    {
        for (var i = 1; i < a.length; ++i)
            if (a[i].length != a[0].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static int max(int...a)
    {
        var maxVal = a[0];

        for (var i = 1; i < a.length; ++i)
            maxVal = Math.max(maxVal, a[i]);

        return maxVal;
    }

    public static int min(int...a)
    {
        var minVal = a[0];

        for (var i = 1; i < a.length; ++i)
            minVal = Math.min(minVal, a[i]);

        return minVal;
    }

    public static void print(int n, int...a)
    {
        var fmt = String.format("%%0%dd ", n);

        for (var val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void print(int...a)
    {
        print(1, a);
    }

    public static void print(double...a)
    {
        for (var val : a)
            System.out.printf("%f", val);

        System.out.println();
    }

    public static void print(int n, int[]...a)
    {
        for (var array : a)
            print(n, array);
    }

    public static void print(String...str)
    {
        for (var s : str)
            System.out.println(s);
    }

    public static void print(byte...b)
    {
        print(b.length, b);
    }

    public static void print(int length, byte...b)
    {
        print(length, ' ', '\n', b);
    }

    public static void print(int length, char sep, char end, byte...b)
    {
        for (var i = 0; i < length; ++i)
            System.out.printf("%d%c", b[i], sep);

        System.out.print(end);
    }

    public static void reverse(int [] a)
    {
        var halfLen = a.length / 2;

        for (var i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] c)
    {
        var halfLen = c.length / 2;

        for (var i = 0; i < halfLen; ++i)
            swap(c, i, c.length - 1 - i);
    }

    public static int [] reversed(int [] a)
    {
        var r = new int[a.length];

        for (var i = a.length - 1; i >= 0; --i)
            r[a.length - 1 - i] = a[i];

        return r;
    }

    public static void selectionSort(int [] a)
    {
        selectionSortAscending(a);
    }

    public static void selectionSort(int [] a, boolean desc)
    {
        if (desc)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void shuffle(Random r, int [] a, int count)
    {
        while (count-- > 0)
            swap(a, r.nextInt(a.length), r.nextInt(a.length));
    }

    public static int sum(int...a)
    {
        var total = 0;

        for (var val : a)
            total += val;

        return total;
    }

    public static int sum(int[]...a)
    {
        var total = 0;

        for (var array : a)
            total += sum(array);

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        var total = 0;

        for (var i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] c, int i, int k)
    {
        var temp = c[i];

        c[i] = c[k];
        c[k] = temp;
    }

    public static <T> void swap(T [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static int [][] transposed(int [][] a)
    {
        var t = new int[a[0].length][a.length];

        for (var i = 0; i < a.length; ++i)
            for (var j = 0; j < a[i].length; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}
