package com.yusuflale.app.sensor;

import com.bircekilinc.sensor.Sensor;
import org.csystem.util.console.Console;

import java.io.IOException;

public final class ConnectionUtil {
    private ConnectionUtil()
    {}

    public static void doConnection(String url) throws IOException
    {
        Sensor sensor = null;

        try {
            Console.writeLine("------------------------------------------------------");
            sensor = new Sensor(url);
            sensor.doWork();
            Console.writeLine("------------------------------------------------------");
        }
        catch (IllegalArgumentException ignore) {
            Console.writeLine("Invalid URL!...");
        }
        catch (IllegalStateException ignore) {
            Console.writeLine("Connection problem occurs!...");
        }
        finally {
            if (sensor != null)
                sensor.close();
        }
    }
}
