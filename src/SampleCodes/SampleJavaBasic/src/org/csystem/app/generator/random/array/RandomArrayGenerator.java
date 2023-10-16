package org.csystem.app.generator.random.array;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;

public class RandomArrayGenerator {
    private final int [] m_numbers;

    public RandomArrayGenerator(Random random, int count, int min, int bound)
    {
        m_numbers = ArrayUtil.getRandomArray(random, count, min, bound);
    }

    public int getCount()
    {
        return m_numbers.length;
    }

    public int get(int index)
    {
        return m_numbers[index];
    }
}
