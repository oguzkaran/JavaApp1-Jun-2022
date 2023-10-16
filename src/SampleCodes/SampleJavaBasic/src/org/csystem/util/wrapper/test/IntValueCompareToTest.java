package org.csystem.util.wrapper.test;

import org.csystem.util.wrapper.IntValue;

import java.util.Random;
import java.util.Scanner;

public class IntValueCompareToTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Bir sayı giriniz:");
        IntValue count = IntValue.of(kb.nextInt());

        for (IntValue i = IntValue.ZERO; i.compareTo(count) < 0; i = i.inc())
            System.out.printf("%d ", i.getValue());

        System.out.println();

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
