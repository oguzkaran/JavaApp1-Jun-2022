package org.csystem.util.string.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.string.StringUtil.getRandomTextTR;
import static org.csystem.util.string.StringUtil.print;

class JoinArrayListTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();
		ArrayList<String> list = new ArrayList<>();

		for (;;) {
			int count = r.nextInt(0, 11);

			if (count == 0)
				break;

			while (count-- > 0)
				list.add(getRandomTextTR(r, r.nextInt(5, 11)));

			System.out.println("-----------------------------------------------------------------");
			print(list);
			System.out.println("-----------------------------------------------------------------");
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
