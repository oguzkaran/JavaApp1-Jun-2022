/*----------------------------------------------------------------------------------------------------------------------
    BigDewcimal sınıfının scale ve RoundingMode parametreli divide metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.math.RoundingMode;

class App {
    public static void main(String[] args)
    {

        var a = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var b = Console.readBigDecimal("İkinci sayıyı giriniz:");
        var c = a.divide(b, 10, RoundingMode.HALF_UP);

        Console.writeLine(c);
    }
}