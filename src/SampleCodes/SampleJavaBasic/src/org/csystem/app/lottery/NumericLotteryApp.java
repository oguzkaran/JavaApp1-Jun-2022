package org.csystem.app.lottery;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class NumericLotteryApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        NumericLottery numericLottery = new NumericLottery(r);

        for (;;) {
            System.out.print("Kaç tane kupon oynamak istersiniz?");
            int count = Integer.parseInt(kb.nextLine());

            if (count <= 0)
                break;

            ArrayUtil.print(2, numericLottery.getNumbers(count));
        }
    }
}
