/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının reverse metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var r = new Random();
        var s = Console.read("Bir yazı giriniz:");

        Console.writeLine(new StringBuilder(s).reverse().toString());
    }
}
