package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Scanner;

class SqueezeTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);

		for (;;) {
			System.out.print("Birinci yazıyı giriniz:");
			String s1 = kb.nextLine();

			System.out.print("İkinci yazıyı giriniz:");
			String s2 = kb.nextLine();

			System.out.println(StringUtil.squeeze(s1, s2));
			if ("elma".equals(s1))
				break;
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
