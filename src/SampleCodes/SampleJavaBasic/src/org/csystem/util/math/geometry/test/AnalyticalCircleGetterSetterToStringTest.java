package org.csystem.util.math.geometry.test;

import org.csystem.util.math.geometry.AnalyticalCircle;

import java.util.Random;
import java.util.Scanner;

public class AnalyticalCircleGetterSetterToStringTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Input a number:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("---------------------------------------------------");
            double radius = random.nextDouble(-23.34, 23.34);
            double x = random.nextDouble(-200, 200);
            double y = random.nextDouble(-200, 200);

            System.out.printf("Radius:%f, x = %f, y = %f", radius, x, y);
            AnalyticalCircle ac = new AnalyticalCircle(radius, x, y);

            System.out.printf("Radius: %f%n", ac.getRadius());
            System.out.printf("Area: %f%n", ac.getArea());
            System.out.printf("Perimeter: %f%n", ac.getPerimeter());
            System.out.printf("x = %f, y = %f%n", ac.getX(), ac.getY());
            System.out.println(ac.toString());
            System.out.println("---------------------------------------------------");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
