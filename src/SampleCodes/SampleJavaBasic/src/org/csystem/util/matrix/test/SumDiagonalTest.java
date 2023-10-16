package org.csystem.util.matrix.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.matrix.MatrixUtil.getRandomSquareMatrix;
import static org.csystem.util.matrix.MatrixUtil.sumDiagonal;

class SumDiagonalTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Bir sayı giriniz:");
		int count = kb.nextInt();

		for (int i = 0; i < count; ++i) {
			int [][] a = getRandomSquareMatrix(r, r.nextInt(3, 6), 0, 99);
			System.out.println("---------------------------------------------------");
			print(2, a);
			System.out.printf("Esas köşegen üzerindeki sayıların toplamı:%d%n", sumDiagonal(a));
			System.out.println("---------------------------------------------------");
		}
	}

	public static void main(String [] args)
	{
		run();
	}
}

