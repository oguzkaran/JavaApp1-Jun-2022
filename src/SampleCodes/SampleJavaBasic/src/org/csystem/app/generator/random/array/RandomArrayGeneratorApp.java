package org.csystem.app.generator.random.array;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class RandomArrayGeneratorApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Bir sayı giriniz:");
        RandomArrayGenerator generator = new RandomArrayGenerator(r, kb.nextInt(), 0, 99);
        int [] a = new int[generator.getCount()];

        for (int i = 0; i < a.length; ++i)
            a[i] = generator.get(i);

        ArrayUtil.print(2, a);
        ArrayUtil.addBy(1, a);
        ArrayUtil.print(2, a);

        int count = generator.getCount();

        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", generator.get(i));

        System.out.println();
    }
}
