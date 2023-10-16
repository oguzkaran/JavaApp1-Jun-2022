package org.csystem.util.array.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.*;

public class BubbleSortTest {
    private static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        for (;;) {
            System.out.print("Dizinin eleman sayısını giriniz:");
            int count = Integer.parseInt(kb.nextLine());

            if (count <= 0)
                break;

            int [] a  = getRandomArray(r, count, 0, 100);

            print(2, a);

            boolean desc = r.nextBoolean();

            bubbleSort(a, desc);

            System.out.printf("%s sıralanmış dizi:%n", desc ? "Büyükten küçüğe" : "Küçükten büyüğe");

            print(2, a);
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String [] args)
    {
        run();
    }
}
