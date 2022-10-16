package org.csystem.camera.car.factory;

import org.csystem.camera.car.CarCameraInfo;
import org.csystem.util.string.StringUtil;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

public class CarCameraFactory implements ICarCameraInfoFactory {
    private final Random m_random = new Random();

    private String generatePlate()
    {
        var num = m_random.nextInt(1, 82);
        var text = StringUtil.getRandomTextEN(m_random, m_random.nextInt(1, 4)).toUpperCase();
        var value = m_random.nextInt(1, 10000);

        return String.format("%02d %s %04d", num, text, value);
    }

    @Override
    public CarCameraInfo create()
    {
        ThreadUtil.sleep(m_random.nextInt(400, 700));
        return new CarCameraInfo(generatePlate(), m_random.nextDouble(5, 220));
    }
}
