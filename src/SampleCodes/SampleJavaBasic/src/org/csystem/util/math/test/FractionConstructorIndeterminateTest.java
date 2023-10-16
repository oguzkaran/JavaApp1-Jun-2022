package org.csystem.util.math.test;

import org.csystem.util.math.Fraction;

import java.util.Random;
import java.util.Scanner;

public class FractionConstructorIndeterminateTest {
    public static void run()
    {
        try {
            Fraction fraction = new Fraction(0, 0);
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
