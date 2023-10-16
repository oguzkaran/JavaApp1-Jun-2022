package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Scanner;

class GetRandomTextTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();
		
		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n < 1)
				break;
			
			System.out.printf("Şifre:%s%n", StringUtil.getRandomTextTR(r, n));
			System.out.printf("Password:%s%n", StringUtil.getRandomTextEN(r, n));
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}

	public static void main(String [] args)
	{
		run();
	}
}
