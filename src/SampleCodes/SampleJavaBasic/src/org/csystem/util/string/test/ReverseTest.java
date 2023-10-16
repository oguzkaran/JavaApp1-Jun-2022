package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Scanner;

class ReverseTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		
		for (;;) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			if ("elma".equals(s))
				break;
			
			System.out.printf("Yazının tersi:%s%n", StringUtil.reverse(s));
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}

	public static void main(String [] args)
	{
		run();
	}
}

