package org.csystem.app.factory;

import org.csystem.util.iterable.IntRange;
import org.csystem.util.math.geometry.AnalyticalCircle;
import org.csystem.util.math.geometry.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCircleFactory {
    private final Random m_random;
    private final double m_min, m_bound;

    private void getCirclesCallback(ArrayList<Circle> circles)
    {
        circles.add(new AnalyticalCircle(m_random.nextDouble(m_min, m_bound), m_random.nextDouble(m_min, m_bound),
                m_random.nextDouble(m_min, m_bound)));
    }

    public RandomCircleFactory(Random random, double min, double bound)
    {
        m_random = random;
        m_min = min;
        m_bound = bound;
    }

    public List<Circle> getCircles(int count)
    {
        var circles = new ArrayList<Circle>();

        IntRange.of(0, count).forEach(i -> getCirclesCallback(circles));

        return circles;
    }
}
