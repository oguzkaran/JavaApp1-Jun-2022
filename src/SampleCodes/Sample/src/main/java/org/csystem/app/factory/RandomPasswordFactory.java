package org.csystem.app.factory;

import org.csystem.util.string.StringUtil;

import java.util.Optional;
import java.util.Random;

public class RandomPasswordFactory {
    private final Random m_random;
    private final int m_minLength;
    private final int m_bound;

    public RandomPasswordFactory(Random random, int minLength, int bound)
    {
        m_random = random;
        m_minLength = minLength;
        m_bound = bound;
    }

    public Optional<String> getPassword()
    {
        return m_random.nextBoolean() ? Optional.of(StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_minLength, m_bound)))
                : Optional.empty();
    }
}
