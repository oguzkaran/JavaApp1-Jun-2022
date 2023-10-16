package org.csystem.util.tuple.test;

import org.csystem.util.collection.CollectionUtil;
import org.csystem.util.tuple.Pair;

import java.util.ArrayList;
import java.util.Random;

public class PairConstructorTest {
    public static void run()
    {
        Random random = new Random();
        ArrayList<Pair<String, Sensor>> sensors = new ArrayList<>();
        SensorFactory factory = new SensorFactory();

        while (true) {
            Sensor sensor = factory.createSensor();
            sensors.add(new Pair<>(sensor.getName(), sensor));
            if (random.nextInt(-99, 100) == 0)
                break;
        }

        CollectionUtil.print(sensors, "\n", "");
        /*
        for (Pair<String, Sensor> sensor : sensors)
            Console.writeLine("%s -> %s", sensor.first, sensor.second);

         */
    }

    public static void main(String[] args)
    {
        run();
    }
}

