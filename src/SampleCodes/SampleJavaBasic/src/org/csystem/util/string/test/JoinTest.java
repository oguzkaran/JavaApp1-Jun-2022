package org.csystem.util.string.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.string.StringUtil.*;

class JoinTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("min değerini giriniz:");
		int min = Integer.parseInt(kb.nextLine());
		System.out.print("bound değerini giriniz:");
		int bound = Integer.parseInt(kb.nextLine());

		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int count = Integer.parseInt(kb.nextLine());
			
			if (count < 1)
				break;

			String [] texts = getRandomTextsTR(r,count, min, bound);

			System.out.println("-----------------------------------------------------------------");
			print(texts);

			System.out.printf("Text:%s%n", join(texts, '-'));
			System.out.printf("Text:%s%n", join(texts, "--"));

			System.out.println("-----------------------------------------------------------------");
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
