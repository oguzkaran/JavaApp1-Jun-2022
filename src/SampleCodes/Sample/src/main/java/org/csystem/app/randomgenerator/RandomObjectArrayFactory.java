package org.csystem.app.randomgenerator;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.datetime.random.DateTimeUtil;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class RandomObjectArrayFactory {
    private final Random m_random;

    private Object createObject()
    {
        Object object;

        return switch (m_random.nextInt(6)) {
            case 0 -> StringUtil.getRandomTextTR(m_random, m_random.nextInt(10) + 1);
            case 1 -> DateTimeUtil.randomDate(m_random);
            case 2 -> ArrayUtil.getRandomArray(m_random, m_random.nextInt(10) + 5, 0, 99);
            case 3 -> m_random.nextInt(100);
            case 4 -> m_random.nextDouble();
            default -> (char)(m_random.nextInt(26) + (m_random.nextBoolean() ? 'A' : 'a'));
        };
    }

    private Object [] fillObjects(Object [] objects)
    {
        for (int i = 0; i < objects.length; ++i)
            objects[i] = createObject();

        return objects;
    }

    public RandomObjectArrayFactory()
    {
        this(new Random());
    }

    public RandomObjectArrayFactory(Random random)
    {
        m_random = random;
    }

    public Object[] getObjects(int count)
    {
        return fillObjects(new Object[count]);
    }
}
