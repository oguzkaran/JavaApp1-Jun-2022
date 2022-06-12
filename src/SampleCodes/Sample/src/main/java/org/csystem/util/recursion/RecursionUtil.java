package org.csystem.util.recursion;

import org.csystem.util.console.Console;

public class RecursionUtil {
    private static int fibonacciNumberRecur(int n)
    {
        if (n <= 2)
            return n - 1;

        return fibonacciNumberRecur(n - 1) + fibonacciNumberRecur(n - 2);
    }

    private static void reversedRecur(char [] chars, int left, int right)
    {
        if (left >= right)
            return;

        char temp;

        temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        reversedRecur(chars, left + 1, right - 1);
    }

    private static void writeNumberRecur(int val, int radix)
    {
        if (val / radix != 0)
            writeNumberRecur(val / radix, radix);

        System.out.write((char)((val % radix >= 10 ? 'A' - 10 : '0') + val % radix));
    }

    private static void writeReverseRecur(String s, int i)
    {
        if (i == s.length())
            return;

        writeReverseRecur(s, i + 1);
        Console.write(s.charAt(i));
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static int fibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        return fibonacciNumberRecur(n);
    }

    public static String reversed(String s)
    {
        char [] chars = s.toCharArray();

        reversedRecur(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    public static void writeNumber(int val)
    {
        writeNumber(val, 10);
    }

    public static void writeNumber(int val, int radix)
    {
        if (val < 0) {
            System.out.write('-');
            val = -val;
        }

        writeNumberRecur(val, radix);
        System.out.flush();
    }
    public static void writeReverse(String s)
    {
        writeReverseRecur(s, 0);
        System.out.flush();
    }
}
