package org.csystem.app.ballfall;

import org.csystem.game.ballfall.BallFall;

public class BallFallApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);

		BallFall bf = new BallFall();

		for (;;) {
			System.out.print("Input width and height:");
			int width = kb.nextInt();
			int height = kb.nextInt();

			if (width == 0)
				break;

			bf.play(width, height);
			System.out.println(bf);
		}
	}

	public static void main(String[] args)
	{
		run();
	}
}
