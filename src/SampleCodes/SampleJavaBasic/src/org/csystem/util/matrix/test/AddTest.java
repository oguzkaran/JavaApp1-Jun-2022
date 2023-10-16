package org.csystem.util.matrix.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.matrix.MatrixUtil.*;

class AddTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Bir sayı giriniz:");
		int count = kb.nextInt();

		for (int i = 0; i < count; ++i) {
			int m = r.nextInt(4, 10);
			int n = r.nextInt(4, 10);
			int [][] a = getRandomMatrix(r, m, n, 0, 99);
			int [][] b = getRandomMatrix(r, m, n, 0, 99);

			System.out.println("---------------------------------------------------");
			print(2, a);
			System.out.println();
			print(2, b);
			System.out.println("Matrislerin toplamı:");
			print(3, add(a, b));
			System.out.println("---------------------------------------------------");
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}

