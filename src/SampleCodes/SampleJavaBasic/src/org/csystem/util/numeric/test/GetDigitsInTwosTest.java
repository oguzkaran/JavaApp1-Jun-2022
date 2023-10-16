package org.csystem.util.numeric.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.numeric.NumberUtil.getDigitsInThrees;
import static org.csystem.util.numeric.NumberUtil.getDigitsInTwos;

public class GetDigitsInTwosTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Bir sayı giriniz:");
        int n = kb.nextInt();

        while (n-- > 0) {
            long val = r.nextLong();
            System.out.printf("%d -> ", val);
            print(getDigitsInTwos(val));
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String [] args)
    {
        run();
    }
}
