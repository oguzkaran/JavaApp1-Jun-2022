package org.csystem.util.matrix.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.matrix.MatrixUtil.getRandomMatrix;
import static org.csystem.util.matrix.MatrixUtil.transpose;

class TransposeTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Bir sayı giriniz:");
		int count = kb.nextInt();

		for (int i = 0; i < count; ++i) {
			int [][] a = getRandomMatrix(r, r.nextInt(4, 10), r.nextInt(4, 10), 0, 99);
			System.out.println("---------------------------------------------------");
			print(2, a);
			System.out.println("Matrisin devriği:");
			print(2, transpose(a));
			System.out.println("---------------------------------------------------");
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}

