package org.csystem.util.console.test;

import org.csystem.util.console.Console;

public class ReadIntTest {
    public static void run()
    {
        int a = Console.readInt("Birinci sayıyı giriniz:", "Hatalı sayı girdiniz!...");
        int b = Console.readInt("İkinci sayıyı giriniz:", "Hatalı sayı girdiniz!...");

        Console.writeLine("%d + %d = %d", a, b, a + b);
    }
    public static void main(String[] args)
    {
        run();
    }
}
