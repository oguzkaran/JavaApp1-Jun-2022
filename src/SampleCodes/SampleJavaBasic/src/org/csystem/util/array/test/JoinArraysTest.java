package org.csystem.util.array.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.*;

public class JoinArraysTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        for (;;) {
            System.out.print("Dizilerin eleman sayılarını giriniz:");
            int count1 = kb.nextInt();
            int count2 = kb.nextInt();

            if (count1 <= 0 && count2 <= 0)
                break;

            int [] a  = getRandomArray(r, count1, 0, 100);
            int [] b  = getRandomArray(r, count2, 0, 100);

            print(2, a);
            print(2, b);
            print(2, join(a, b));
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String [] args)
    {
        run();
    }
}
