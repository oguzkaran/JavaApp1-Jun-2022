package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConverter;
import org.csystem.util.system.SystemUtil;

import java.nio.ByteBuffer;

public class Application {
    public static void run(String[] args)
    {
        for (;;) {
            short a = Console.readShort("Bir sayı giriniz:");

            ByteBuffer byteBuffer = ByteBuffer.allocate(2).putShort(a);

            Console.writeLine(SystemUtil.endianText(byteBuffer));
            SystemUtil.changeEndian(byteBuffer);
            Console.writeLine(SystemUtil.endianText(byteBuffer));
            short b = BitConverter.toLittleEndian(a);

            Console.writeLine("a = %d, a = %04X", a, a);
            Console.writeLine("b = %d, b = %04X", b, b);

            if (a == 0)
                break;
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
