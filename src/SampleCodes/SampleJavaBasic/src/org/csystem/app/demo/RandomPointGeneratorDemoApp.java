package org.csystem.app.demo;

import org.csystem.generator.random.RandomPointFactory;
import org.csystem.util.math.geometry.Point;

import java.util.Random;
import java.util.Scanner;

class RandomPointGeneratorDemoApp {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random random = new Random();
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();

		RandomPointFactory factory = new RandomPointFactory(random);

		for (int i = 0; i < n; ++i) {
			double min = random.nextDouble(-10, 10);
			double bound =  random.nextDouble(10);

			Point p = factory.createPoint(min, bound);

			System.out.println("-------------------------------------------");
			System.out.printf("min = %f, bound = %f%n", min, bound);

			if (p == null) { //***
				System.out.println("Geçersiz sınır değerler!...");
				continue;
			}

			System.out.println(p.toString());
			System.out.println("-------------------------------------------");
		}
	}

	public static void main(String[] args)
	{
		run();
	}
}