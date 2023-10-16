package org.csystem.util.math.geometry.test;

import org.csystem.util.math.geometry.AnalyticalCircle;

public class AnalyticalCircleDefaultConstructorTest {
    public static void run()
    {
        System.out.println("---------------------------------------------------");
        AnalyticalCircle ac = new AnalyticalCircle();

        System.out.printf("Radius: %f%n", ac.getRadius());
        System.out.printf("Area: %f%n", ac.getArea());
        System.out.printf("Perimeter: %f%n", ac.getPerimeter());
        System.out.printf("x = %f, y = %f%n", ac.getX(), ac.getY());
        System.out.println(ac.toString());
        System.out.println("---------------------------------------------------");

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
