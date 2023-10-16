package org.csystem.util.math.geometry.test;

import org.csystem.util.math.geometry.AnalyticalCircle;

public class AnalyticalCircleOffsetTest {
    public static void run()
    {
        System.out.println("---------------------------------------------------");
        AnalyticalCircle ac = new AnalyticalCircle(3);

        System.out.println(ac.toString());
        ac.offset(2.45);
        System.out.println(ac.toString());
        ac.offset(3, -90);
        System.out.println(ac.toString());
        System.out.println("---------------------------------------------------");

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
