package org.csystem.generator.random;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.math.Complex;
import org.csystem.util.math.geometry.Point;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomObjectArrayGenerator {
    private final RandomGenerator m_randomGenerator;

    //String, Complex, Point, Integer, int [], Boolean, Character
    private Object createObject()
    {
        return switch (m_randomGenerator.nextInt(7)) {
            case 0 -> StringUtil.getRandomTextTR(m_randomGenerator, m_randomGenerator.nextInt(5, 11));
            case 1 -> new Complex(m_randomGenerator.nextDouble(-10, 10), m_randomGenerator.nextDouble(-10, 10));
            case 2 -> Point.createCartesian(m_randomGenerator.nextDouble(-100, 100), m_randomGenerator.nextDouble(-100, 100));
            case 3 -> m_randomGenerator.nextInt(-128, 127);
            case 4 -> m_randomGenerator.nextBoolean();
            case 5 -> (char)((m_randomGenerator.nextBoolean() ? 'A' : 'a') + m_randomGenerator.nextInt(26));
            default -> ArrayUtil.getRandomArray(m_randomGenerator, m_randomGenerator.nextInt(5, 16), 0, 100);
        };
    }

    public RandomObjectArrayGenerator()
    {
        m_randomGenerator = new Random();
    }

    public RandomObjectArrayGenerator(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Object [] createObjects(int count)
    {
        Object [] objects = new Object[count];

        for (int i = 0; i < count; ++i)
            objects[i] = createObject();

        return objects;
    }
}
