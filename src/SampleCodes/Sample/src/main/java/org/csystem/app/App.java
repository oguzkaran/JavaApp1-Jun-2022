/*----------------------------------------------------------------------------------------------------------------------
    Stack sınıfının search metodu en üstteki eleman 1(bir) numaralı indeks olmak üzere ilk bulduğu elemanın indeks
    numarasına geri döner. Bulamazsa -1 değerine geri döner. Eşitlik kontrolünü indexOf metodundaki gibi yapar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.iterable.IntRange;

import java.util.Random;
import java.util.Stack;

class App {
    public static void main(String[] args)
    {
        var random = new Random();
        var stack = new Stack<Integer>();
        var count = Console.readInt("Bir sayı giriniz:");

        IntRange.of(0, count).forEach(i -> stack.push(random.nextInt(100)));

        var a = random.nextInt(100);
        Console.writeLine("Value:%d", a);
        int index = stack.search(a);

        int i = 0;

        while (!stack.empty())
            Console.writeLine("%d -> %d", ++i, stack.pop());

        if (index != -1)
            Console.writeLine("%d sayısı %d. indekste bulundu", a, index);
        else
            Console.writeLine("%d sayısı bulunamadı", a, index);
    }
}

