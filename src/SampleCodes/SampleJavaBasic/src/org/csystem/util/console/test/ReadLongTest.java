package org.csystem.util.console.test;

import org.csystem.util.console.Console;

public class ReadLongTest {
    public static void run()
    {
        long a = Console.readLong("Birinci sayıyı giriniz:", "Hatalı sayı girdiniz!...");
        long b = Console.readLong("İkinci sayıyı giriniz:", "Hatalı sayı girdiniz!...");

        Console.writeLine("%d + %d = %d", a, b, a + b);
    }
    public static void main(String[] args)
    {
        run();
    }
}
