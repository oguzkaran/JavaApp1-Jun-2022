package org.csystem.util.string.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.string.StringUtil.getRandomTextsEN;
import static org.csystem.util.string.StringUtil.getRandomTextsTR;

class GetRandomTextsENTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Input min value:");
		int min = Integer.parseInt(kb.nextLine());

		System.out.print("Input bound value:");
		int bound = Integer.parseInt(kb.nextLine());
		
		for (;;) {
			System.out.print("Input count:");
			int count = Integer.parseInt(kb.nextLine());
			
			if (count < 1)
				break;

			int n = r.nextInt(min, bound);

			print(getRandomTextsEN(r, count, min, bound));
			System.out.printf("n = %d%n", n);
			print(getRandomTextsEN(r, count, n));
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
