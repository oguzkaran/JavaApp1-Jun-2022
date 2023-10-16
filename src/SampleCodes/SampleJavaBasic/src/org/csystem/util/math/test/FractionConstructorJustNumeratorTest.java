package org.csystem.util.math.test;

import org.csystem.util.math.Fraction;

public class FractionConstructorJustNumeratorTest {
    public static void run()
    {
        Fraction fraction = new Fraction(10);

        System.out.printf("%d / %d%n", fraction.getNumerator(), fraction.getDenominator());
    }

    public static void main(String[] args)
    {
        run();
    }
}
