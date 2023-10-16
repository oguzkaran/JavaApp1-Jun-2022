package org.csystem.util.array.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.*;

public class DrawHistogramTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        for (;;) {
            System.out.print("Dizinin eleman sayısını giriniz:");
            int count = Integer.parseInt(kb.nextLine());

            if (count <= 0)
                break;

            int [] a  = getRandomArray(r, count, 0, 11);
            System.out.println("-----------------------------------------------------------");
            print(a);
            int [] data = getHistogramData(a, 10);
            print(data);
            System.out.println("Histogram:");
            drawHistogram(data, 10, 'X');
            System.out.println("-----------------------------------------------------------");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String [] args)
    {
        run();
    }
}
