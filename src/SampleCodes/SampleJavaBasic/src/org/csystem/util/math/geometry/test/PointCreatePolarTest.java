package org.csystem.util.math.geometry.test;

import org.csystem.util.math.geometry.Point;

import java.util.Random;
import java.util.Scanner;

public class PointCreatePolarTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Input a number:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("---------------------------------------------------");
            double radius = random.nextDouble(-23.34, 23.34);
            double theta = random.nextDouble(-2 * Math.PI, 2 * Math.PI);

            System.out.printf("Generated Polar Coordinate:(%f, %f)%n", radius, theta);
            Point p = Point.createPolar(radius, theta);

            System.out.println(p.toString());
            System.out.println("---------------------------------------------------");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
