package org.csystem.app.craps.simulation;

import org.csystem.game.craps.Craps;

public class CrapsSimulation {
	private double m_probability;

	public double getProbability()
	{
		return m_probability;
	}

	public void run(int count)
	{
		int winCount = 0;	
		java.util.Random r = new java.util.Random();
		
		for (int i = 0; i < count; ++i) {
			Craps craps = new Craps(r);
			
			craps.play();
			
			if (craps.isWin())
				++winCount;
		}
		
		m_probability = (double)winCount / count;
	}
}
