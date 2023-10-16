package org.csystem.util.numeric.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.numeric.NumberUtil.numToTextTR;

public class NumToTextTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Bir sayı giriniz:");
        int n = kb.nextInt();

        while (n-- > 0) {
            int val = r.nextInt(-100, 1000);
            System.out.printf("%d -> %s%n", val, numToTextTR(val));
        }

        System.out.println("Tekrar yapıyor musunuz?");

    }

    public static void main(String [] args)
    {
        run();
    }
}
