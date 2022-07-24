/*----------------------------------------------------------------------------------------------------------------------
    DateTimeFormatterUtil ve DateTimeConvertUtil sınıfları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.time.LocalDateTime;

import static org.csystem.util.datetime.DateTimeConvertUtil.*;
import static org.csystem.util.datetime.DateTimeFormatterUtil.*;

class App {
    public static void main(String[] args)
    {
        var now = LocalDateTime.now();
        var millis = toMilliseconds(now);

        Console.writeLine(DATETIME_DOT_SEC_TR.format(now));
        Console.writeLine(millis);

        var dateTime = toLocalDateTime(millis);

        Console.writeLine(DATETIME_DOT_SEC_TR.format(dateTime));
    }
}