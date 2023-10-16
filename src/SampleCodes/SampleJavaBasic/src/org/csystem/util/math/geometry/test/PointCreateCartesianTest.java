package org.csystem.util.math.geometry.test;

import org.csystem.util.math.geometry.Point;

import java.util.Random;
import java.util.Scanner;

public class PointCreateCartesianTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Input a number:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("---------------------------------------------------");
            double x = random.nextDouble(-23.34, 23.34);
            double y = random.nextDouble(-23.34, 23.34);

            System.out.printf("Generated Cartesian Coordinate:(%f, %f)%n", x, y);
            Point p = Point.createCartesian(x, y);

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
