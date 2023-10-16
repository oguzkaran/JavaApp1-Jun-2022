package org.csystem.util.tuple.test;

import org.csystem.util.string.StringUtil;

import java.util.Random;

public class SensorFactory {
    private final Random m_random = new Random();

    private String createRandomHost()
    {
        return String.format("%d.%d.%d.%d", m_random.nextInt(256), m_random.nextInt(256), m_random.nextInt(256), m_random.nextInt(256));
    }

    public Sensor createSensor()
    {
        return new Sensor(StringUtil.getRandomTextTR(m_random, m_random.nextInt(5, 11)), createRandomHost(), m_random.nextInt(1024, 65535));
    }
}
