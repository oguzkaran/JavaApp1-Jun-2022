package org.csystem.camera.car;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CarCameraInfo implements Comparable<CarCameraInfo> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyy kk:mm:ss");
    private final String m_plate;
    private final double m_speed;
    private final LocalDateTime m_passDateTime;

    public CarCameraInfo(String plate, double speed)
    {
        m_plate = plate;
        m_speed = speed;
        m_passDateTime = LocalDateTime.now();
    }

    public String getPlate()
    {
        return m_plate;
    }

    public LocalDateTime getPassDateTime()
    {
        return m_passDateTime;
    }

    public double getSpeed()
    {
        return m_speed;
    }

    //...

    @Override
    public int compareTo(CarCameraInfo other)
    {
        if (m_passDateTime.isBefore(other.m_passDateTime))
            return -1;
        if (m_passDateTime.isAfter(other.m_passDateTime))
            return 1;

        return 0;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof CarCameraInfo c))
            return false;

        return c.m_plate.equals(m_plate) && c.m_passDateTime.equals(m_passDateTime);
    }

    @Override
    public String toString()
    {
        return String.format("[%s] (%f km / h) %s", m_plate, m_speed, FORMATTER.format(m_passDateTime));
    }
}
