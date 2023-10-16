package org.csystem.util.string.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.string.StringUtil.split;

class SplitTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String str = kb.nextLine();
			
			if ("elma".equals(str))
				break;

			System.out.print("Ayraçları giriniz:");
			String delimiters = kb.nextLine();

			System.out.println("-----------------------------------------------------------------");
			String [] words = split(str, delimiters, r.nextBoolean());

			for (int i = 0; i < words.length; ++i)
				System.out.printf("{%s}%n", words[i]);

			System.out.println("-----------------------------------------------------------------");
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
