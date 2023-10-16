/*----------------------------------------------------------------
	FILE		: ArrayUtil.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 22.07.2023

	Utility class for array operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.array;

import java.util.random.RandomGenerator;

import static java.lang.Math.floor;

public final class ArrayUtil {
    private ArrayUtil()
    {}

    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k)
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
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (max < a[k]) {
                    max = a[k];
                    maxIndex = k;
                }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    public static void addBy(int val, int [] a)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] += val;
    }
    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static int [] copyOf(int [] a, int newLength)
    {
        int [] result = new int[newLength];
        int len = Math.min(a.length, newLength);

        for (int i = 0; i < len; ++i)
            result[i] = a[i];

        return result;
    }

    public static void drawHistogram(int [] data, int count, char ch)
    {
        int maxVal = max(data);

        for (int val : data) {
            int charCount = (int) floor(val * count / (double) maxVal);

            while (charCount-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int [] enlarge(int [] a, int newLength)
    {
        return newLength <= a.length ? a : copyOf(a, newLength);
    }

    public static void fillRandomArray(RandomGenerator randomGenerator, int [] a, int min, int bound)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = randomGenerator.nextInt(min, bound);
    }

    public static void fillRandomArray(RandomGenerator randomGenerator, double [] a, double min, double bound)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = randomGenerator.nextDouble(min, bound);
    }

    public static int [] getHistogramData(int [] a, int n)
    {
        int [] counts = new int[n + 1];

        for (int val : a)
            ++counts[val];

        return counts;
    }

    public static int [] getRandomArray(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        int [] a = new int[count];

        fillRandomArray(randomGenerator, a, min, bound);

        return a;
    }

    public static double [] getRandomArray(RandomGenerator randomGenerator, int count, double min, double bound)
    {
        double [] a = new double[count];

        fillRandomArray(randomGenerator, a, min, bound);

        return a;
    }

    public static int [] join(int [] a, int [] b)
    {
        int [] result = new int[a.length + b.length];
        int idx = 0;

        for (int val : a)
            result[idx++] = val;

        for (int val : b)
            result[idx++] = val;

        return result;
    }

    public static int min(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            if (a[i] < result)
                result = a[i];

        return result;
    }

    public static int max(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            if (result < a[i])
                result = a[i];

        return result;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void print(double [] a)
    {
        for (double val : a)
            System.out.printf("%f%n", val);
    }

    public static void print(int [] a)
    {
        print(1, a);
    }

    public static void print(int n, int [] a)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void print(byte [] a, int start, int count)
    {
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", a[i + start]);
    }

    public static void print(String [] s)
    {
        for (String str : s)
            System.out.println(str);
    }

    public static void print(int [][] a)
    {
        print(1, a);
    }

    public static void print(int n, int [][] a)
    {
        for (int[] array : a)
            print(n, array);
    }


    public static void reverse(int [] a)
    {
        for (int i = 0; i < a.length / 2; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(double [] a)
    {
        for (int i = 0; i < a.length / 2; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] chars)
    {
        for (int i = 0; i < chars.length / 2; ++i)
            swap(chars, i, chars.length - 1 - i);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(double [] a, int i, int k)
    {
        double temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }
}
