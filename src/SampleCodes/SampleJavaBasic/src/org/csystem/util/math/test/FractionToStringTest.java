package org.csystem.util.math.test;

import org.csystem.util.math.Fraction;

public class FractionToStringTest {
    public static void run()
    {
        Fraction fraction1 = new Fraction(9, 12);
        Fraction fraction2 = new Fraction(-9, 12);
        Fraction fraction3 = new Fraction(10);

        System.out.println(fraction1.toString());
        System.out.println(fraction2.toString());
        System.out.println(fraction3.toString());
    }

    public static void main(String[] args)
    {
        run();
    }
}
