package org.csystem.util.wrapper.test;

import org.csystem.util.wrapper.IntValue;

import java.util.Random;
import java.util.Scanner;

public class IntValueSubtractTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            IntValue iVal1 = IntValue.of(r.nextInt(-128, 128));
            IntValue iVal2 = IntValue.of(r.nextInt(-128, 128));
            System.out.println("--------------------------------------------------------------------------------------");

            IntValue result = iVal1.subtract(iVal2);

            System.out.printf("%d - %d = %d%n", iVal1.getValue(), iVal2.getValue(), result.getValue());
            System.out.println("--------------------------------------------------------------------------------------");
        }
        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
