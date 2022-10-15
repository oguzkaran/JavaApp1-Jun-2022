package org.csystem.app.camera.car;

import org.csystem.app.camera.car.data.entity.CarCameraInfo;
import org.csystem.util.string.StringUtil;

import java.util.Random;

public class RandomCarCameraInfoFactory {
    private final Random m_random;

    private String generatePlate()
    {
        var num = m_random.nextInt(1, 82);
        var text = StringUtil.getRandomTextEN(m_random, m_random.nextInt(1, 4)).toUpperCase();
        var value = m_random.nextInt(1, 10000);

        return String.format("%02d %s %04d", num, text, value);
    }

    public RandomCarCameraInfoFactory(Random random)
    {
        m_random = random;
    }

    public CarCameraInfo createCarCameraInfo()
    {
        return new CarCameraInfo(generatePlate(), m_random.nextDouble(5, 220));
    }
}

