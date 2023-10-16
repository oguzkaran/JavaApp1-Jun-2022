package org.csystem.util.math.test;

import org.csystem.util.math.Fraction;

import java.util.Random;
import java.util.Scanner;

public class FractionDivideTest {
    private static Fraction createRandomFraction(Random random)
    {
        int a, b;

        a = random.nextInt(-10, 10);

        while (true) {
            b = random.nextInt(-10, 10);

            if (b != 0)
                break;
        }

        return new Fraction(a, b);
    }

    public static void run()
    {
        Random random = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.print("Bir sayı giriniz:");
        int n = kb.nextInt();

        while (n-- > 0) {
            System.out.println("-----------------------------------------------------------------------------");

            Fraction fraction1 = createRandomFraction(random);
            Fraction fraction2 = createRandomFraction(random);
            Fraction result = fraction1.divide(fraction2);

            System.out.printf("%d / %d  / %d / %d  = %d / %d%n",
                    fraction1.getNumerator(), fraction1.getDenominator(),
                    fraction2.getNumerator(), fraction2.getDenominator(),
                    result.getNumerator(), result.getDenominator());


            System.out.println("-----------------------------------------------------------------------------");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
