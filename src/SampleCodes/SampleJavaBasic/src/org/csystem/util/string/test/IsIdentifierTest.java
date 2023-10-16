package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Scanner;

class IsIdentifierTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);

		for (;;) {
			System.out.print("Değişken ismini giriniz:");
			String s = kb.nextLine();

			System.out.println(StringUtil.isIdentifier(s) ? "Geçerli" : "Geçersiz");

			if ("elma".equals(s))
				break;
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}
