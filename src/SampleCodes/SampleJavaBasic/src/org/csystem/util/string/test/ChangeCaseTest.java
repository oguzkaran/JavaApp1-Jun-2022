package org.csystem.util.string.test;


import org.csystem.util.string.StringUtil;

import java.util.Scanner;

class ChangeCaseTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);

		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();

			System.out.println(StringUtil.changeCase(s));

			if ("elma".equals(s))
				break;
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
