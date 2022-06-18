/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz. Örnekte StringBuilder sınıfının replace metodunun kullanıldığına dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var s = Console.read("Input a text:");
        var sb = new StringBuilder(s);

        sb.setLength(sb.length() + 10);

        Console.writeLine("(%s)", sb);
        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("--------------------------------");
        Console.writeLine("(%s)", sb);
        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("--------------------------------");
        var idxFirst = sb.indexOf("\0");
        var idxLast = sb.lastIndexOf("\0");

        sb.replace(idxFirst, idxLast + 1, "istanbul");

        Console.writeLine("(%s)", sb);
        Console.writeLine("Length:%d", sb.length());
        Console.writeLine("--------------------------------");

        int len = sb.length();

        for (int i = 0; i < len; ++i)
            if (sb.charAt(i) == '\0')
                Console.write("%d ", i);

        Console.writeLine();
    }
}
