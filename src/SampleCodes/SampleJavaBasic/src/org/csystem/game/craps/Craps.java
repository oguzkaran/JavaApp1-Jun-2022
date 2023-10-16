package org.csystem.game.craps;

import java.util.Random;

public class Craps {
	private boolean m_win;
	private final Random m_random;
	
	private int roll()
	{
		return m_random.nextInt(1, 7) + m_random.nextInt(1, 7);
	}
	
	private void rollIndeterminate(int result)
	{
		int total;
		
		while ((total = roll()) != result && total != 7)
			;
		
		m_win = total == result;
	}

	public Craps()
	{
		m_random = new Random();
	}

	public Craps(Random r)
	{
		m_random = r;
	}

	public boolean isWin()
	{
		return m_win;
	}

	public void play()
	{		
		int total = roll();
		
		switch (total) {
			case 7, 11 -> m_win = true;
			case 2, 3, 12 -> m_win = false;
			default -> rollIndeterminate(total);
		}
	}
}
