package org.csystem.util.string.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.string.StringUtil.fillRandomTextsEN;

class FillRandomTextsENTest {
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

			int n = r.nextInt(min, bound);

			String [] texts = new String[count];

			fillRandomTextsEN(r, texts, min, bound);
			print(texts);
			System.out.printf("n = %d%n", n);

			fillRandomTextsEN(r, texts, n);
			print(texts);
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
