package com.yusuflale.app.sensor;

import com.bircekilinc.sensor.Sensor;
import com.ecehidirlar.operation.sensor.SensorOperation;
import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.io.IOException;

public class DemoApp {
    private static void doWork(Sensor sensor, SensorOperation sensorOperation) throws IOException
    {
        try (sensor; sensorOperation) {
            sensorOperation.doWork();
        }
    }

    public static void run()
    {
        while (true) {
            Console.writeLine("------------------------------------------------------");
            try {
                Sensor sensor = new Sensor("www.csystem.org:50500");
                SensorOperation sensorOperation = new SensorOperation(sensor);

                //...

                doWork(sensor, sensorOperation);
            }
            catch (IllegalArgumentException ignore) {
                Console.writeLine("Invalid URL!...");
            }
            catch (IllegalStateException ignore) {
                Console.writeLine("Connection problem occurs!...");
            }
            catch (IOException ignore) {
                Console.writeLine("Problem in IO operations!...");
            }

            Console.writeLine("------------------------------------------------------");
            ThreadUtil.sleep(1000);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
