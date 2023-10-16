package org.csystem.app.io.file.input;

import org.csystem.app.io.file.data.ConnectionInfo;
import org.csystem.app.io.file.data.Sensor;
import org.csystem.util.console.Console;

import java.io.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class DeserializeSensorsApp {
    private static void readObjects(FileInputStream fis) throws IOException, ClassNotFoundException
    {
        while (true) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Sensor s = (Sensor) ois.readObject();

            String description = s.getDescription();
            ConnectionInfo connectionInfo = s.getConnectionInfo();

            Console.writeLine("%s, Description:%s, Port:%s, Host:%s", s, description == null ? "No description" : description,
                    connectionInfo == null ? "No port specified" : connectionInfo.getPortNum(),
                    connectionInfo == null ? "No host specified" : connectionInfo.getHost());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            readObjects(fis);
        }
        catch (EOFException ignore) {

        }
        catch (InvalidClassException ex) {
            Console.writeErrLine("Invalid class to serialize:%s", ex.getMessage());
        }
        catch (ClassNotFoundException ex) {
            Console.writeErrLine("Class not found:%s", ex.getMessage());
        }
        catch (StreamCorruptedException ex) {
            Console.writeErrLine("Invalid file format:%s", ex.getMessage());
        }
        catch (OptionalDataException ex) {
            Console.writeErrLine("Primitive type found instead of Sensor:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.writeErrLine("I/O problem occurs:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
