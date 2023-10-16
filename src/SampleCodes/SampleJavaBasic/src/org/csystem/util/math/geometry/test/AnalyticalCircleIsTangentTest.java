package org.csystem.util.math.geometry.test;

import org.csystem.util.math.geometry.AnalyticalCircle;

public class AnalyticalCircleIsTangentTest {
    public static void run()
    {
        System.out.println("---------------------------------------------------");
        AnalyticalCircle ac1 = new AnalyticalCircle(2, 3, 4);
        AnalyticalCircle ac2 = new AnalyticalCircle(3, 6, 8);

        System.out.println(ac1.isTangent(ac2) ? "Teğet" : "Teğet değil");
        System.out.println("---------------------------------------------------");

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}

