package org.csystem.app.craps;

import org.csystem.app.craps.simulation.CrapsSimulation;

public class CrapsSimulationApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("Kaç kez oynatmak istersiniz?");
			int count = Integer.parseInt(kb.nextLine());
			
			if (count <= 0)
				break;
			
			CrapsSimulation simulation = new CrapsSimulation();
			
			simulation.run(count);
			System.out.println("------------------------------------------------------");			
			System.out.printf("Kazanma Olasılığı:%f%n", simulation.getProbability());
			System.out.println("------------------------------------------------------");			
		}
	}	
}