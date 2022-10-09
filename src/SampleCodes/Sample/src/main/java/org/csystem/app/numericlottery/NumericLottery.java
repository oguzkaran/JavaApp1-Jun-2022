package org.csystem.app.numericlottery;

import java.util.Random;
import java.util.TreeSet;

public class NumericLottery {
    private final Random m_random;

    private TreeSet<Integer> getNumbersSet()
    {
        var set = new TreeSet<Integer>();

        while (set.size() != 6)
            set.add(m_random.nextInt(1, 50));

        return set;
    }
    public NumericLottery()
    {
        this(new Random());
    }

    public NumericLottery(Random r)
    {
        m_random = r;
    }

    public int [] getNumbers()
    {
        var numbers = new int[6];
        var index = 0;

        for (var val : getNumbersSet())
            numbers[index++] = val;

        return numbers;
    }

    public int [][] getNumbers(int n)
    {
        var numbers = new int[n][];

        for (var i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
