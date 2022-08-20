/*----------------------------------------------------------------------------------------------------------------------
    Method Reference çeşitleri:
    1. static metot referansı (static method reference)
    2. Bir nesneye ilişkin non-static metot referansı (reference to an instance method of particular object)
    3. Bir türe ilişkin non-static metot referansı (reference to an instance method of any object of a particular type)
    4. ctor reference (reference to constructor)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var timer = new Timer();

        var random = new Random();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                try {
                    Console.writeLine("Result:%f", MathUtil.log10(random.nextDouble(1, 10)));
                }
                catch (MathResultStatusException ignore) {

                }
            }
        }, 0, 1000);
    }
}

class MathUtil {
    public static double log10(double a) throws MathResultStatusException
    {
        if (a == 0)
            throw new MathResultStatusException("Undefined", MathResultStatus.NEGATIVE_INFINITY);

        if (a < 0)
            throw  new MathResultStatusException("Indeterminate", MathResultStatus.NAN);

        return Math.log10(a);
    }
}

enum MathResultStatus {
    NAN, POSITIVE_INFINITY, NEGATIVE_INFINITY, POSITIVE_ZERO, NEGATIVE_ZERO,
}

class MathResultStatusException extends Exception {
    private final MathResultStatus m_mathResultStatus;

    public MathResultStatusException(String message, MathResultStatus mathResultStatus)
    {
        super(message);
        m_mathResultStatus = mathResultStatus;
    }

    @Override
    public String getMessage()
    {
        return String.format("Message: %s, Status:%s", super.getMessage(), m_mathResultStatus);
    }
}
