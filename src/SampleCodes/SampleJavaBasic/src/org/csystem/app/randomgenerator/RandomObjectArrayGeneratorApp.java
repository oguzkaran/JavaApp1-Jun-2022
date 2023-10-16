package org.csystem.app.randomgenerator;

import org.csystem.generator.random.RandomObjectArrayGenerator;
import org.csystem.util.array.ArrayUtil;
import org.csystem.util.math.Complex;
import org.csystem.util.math.geometry.Point;

import java.util.Random;
import java.util.Scanner;

public class RandomObjectArrayGeneratorApp {
    private static void doWork(Object [] objects)
    {
        for (Object o : objects) {
            System.out.println("-----------------------------------------------------");
            String typeName = o.getClass().getName();
            System.out.printf("Dinamik tür ismi:%s%n", typeName);

            if (o instanceof String s)
                System.out.printf("%s -> %s%n", s, s.toUpperCase());
            else if (o instanceof Complex z)
                System.out.printf("%s sayısının normu:%s%n", z.toString(), z.getNorm());
            else if (o instanceof Point p)
                System.out.printf("x = %.2f, y = %.2f%n", p.getX(), p.getY());
            else if (o instanceof Integer iv) {
                int value = iv;

                System.out.printf("%d * %d = %d%n", value, value, value *  value);
            }
            else if (o instanceof int [] a)
                ArrayUtil.print(2, a);
            else if (o instanceof Boolean b) {
                boolean flag = b;
                System.out.println(flag ? "Doğru" : "Yanlış");
            }
            else if (o instanceof Character ch) {
                char c = ch;
                System.out.printf("Harf:%c%n", c);
            }

            System.out.println("-----------------------------------------------------");
        }
    }

    private static void run()
    {
        Random random = new Random();
        RandomObjectArrayGenerator generator = new RandomObjectArrayGenerator(random);
        Scanner kb = new Scanner(System.in);
        System.out.print("Bir sayı giriniz:");
        int n = kb.nextInt();

        doWork(generator.createObjects(n));
    }

    public static void main(String[] args)
    {
        run();
    }
}
