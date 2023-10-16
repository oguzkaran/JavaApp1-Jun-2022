package org.csystem.game.ballfall;

public class BallFall {
	private String m_shape;
	
	public void fillSpace(int begin, int end)
	{
		for (int i = begin; i < end; ++i)
			m_shape += ' ';
	}
	
	public void fillBall(int ballIndex, int end)
	{
		fillSpace(0, ballIndex);
		m_shape += '*';
		fillSpace(ballIndex + 1, end);
	}
	
	public static boolean updateRightFlag(boolean isRight, int ballIndex, int width)
	{
		if (ballIndex == 0)
			isRight = true;
		else if (ballIndex == width - 1)
			isRight = false;
		
		return isRight;
	}
	
	public static int updateBallIndex(boolean isRight, int ballIndex)
	{
		if (isRight)
			return ballIndex + 1;
		
		return ballIndex - 1;
	}
	
	public BallFall()
	{
		m_shape = "";
	}

	public String getShape()
	{
		return m_shape;
	}

	public void play(int width, int height)
	{		
		m_shape = "";
		
		if (width != 1) {
			int ballIndex = 0;
			boolean isRight = false;
			
			for (int i = 1; i <= height; ++i) {
				m_shape += '|';
				fillBall(ballIndex, width);
				isRight = updateRightFlag(isRight, ballIndex, width);
				ballIndex = updateBallIndex(isRight, ballIndex);
				m_shape += "|\r\n";
			}
		}
		else		
			for (int i = 1; i <= height; ++i)
				m_shape += "|*|\r\n";
	}

	public String toString()
	{
		return getShape();
	}
}
