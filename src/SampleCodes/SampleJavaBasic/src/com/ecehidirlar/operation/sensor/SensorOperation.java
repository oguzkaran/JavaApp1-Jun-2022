package com.ecehidirlar.operation.sensor;

import com.bircekilinc.sensor.Sensor;
import org.csystem.util.console.Console;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.random.RandomGenerator;

public class SensorOperation implements Closeable {
    private Sensor m_sensor;

    public SensorOperation(Sensor sensor)
    {
        if (!sensor.isOpen())
            throw new IllegalArgumentException("Sensor must be open!...");

        Console.writeLine("Sensor Operations begin!...");
    }

    public void doWork() throws IOException
    {
        RandomGenerator randomGenerator = new Random();

        if (randomGenerator.nextBoolean())
            throw new IOException("IO problem");

        Console.writeLine("Sensor Operation!...");
    }

    public void close() throws IOException
    {
        if (m_sensor != null)
            m_sensor.close();
        Console.writeLine("Sensor operation closed!...");
    }
}
