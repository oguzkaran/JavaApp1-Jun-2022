/*----------------------------------------------------------------------------------------------------------------------
    Stream arayüzlerinin dropWhile metotları
    {{{}}}{}{{}}
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.coding.CodingChallenge;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        for (;;) {
            var str = Console.read("Input a text:");

            Console.writeLine("%b", CodingChallenge.areCurlyBracesMatch(str));

            if ("quit".equals(str))
                break;
        }
    }
}


