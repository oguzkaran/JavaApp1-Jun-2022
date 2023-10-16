package org.csystem.generator.random;

import org.csystem.util.math.geometry.Point;

import java.util.random.RandomGenerator;

public class RandomPointFactory {
	private final RandomGenerator m_randomGenerator;

	public RandomPointFactory(RandomGenerator randomGenerator)
	{
		m_randomGenerator = randomGenerator;
	}

	public Point createPoint(double min, double bound)
	{
		if (min >= bound)
			return null;

		return Point.createCartesian(m_randomGenerator.nextDouble(min, bound), m_randomGenerator.nextDouble(min, bound));
	}
}