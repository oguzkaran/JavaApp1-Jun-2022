package org.csystem.util.matrix.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.matrix.MatrixUtil.addBy;
import static org.csystem.util.matrix.MatrixUtil.getRandomMatrix;

class AddByTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Bir sayı giriniz:");
		int count = kb.nextInt();

		for (int i = 0; i < count; ++i) {
			int [][] a = getRandomMatrix(r, r.nextInt(4, 10), r.nextInt(4, 10), 0, 99);
			int val = r.nextInt(2, 7);
			System.out.println("---------------------------------------------------");
			print(2, a);
			System.out.printf("Value:%d%n", val);
			System.out.println("Sonuç:");
			addBy(a, val);
			print(3, a);
			System.out.println("---------------------------------------------------");
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}

