package org.csystem.util.matrix.test;

import static org.csystem.util.matrix.MatrixUtil.isMatrix;

class IsMatrixTest {
	public static void run()
	{
		int [][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int [][] b = {{1, 2, 3}, {4, 5}, {7, 8, 9}};

		System.out.println(isMatrix(a) ? "Matris" : "Matris değil");
		System.out.println(isMatrix(b) ? "Matris" : "Matris değil");
	}

	public static void main(String [] args)
	{
		run();
	}
}

