/*----------------------------------------------------------------------------------------------------------------------
    Soru: İçerisinde rakamlardan oluşan n tane karakterden oluşan bir yazı içerisinde k tane rakamı silerek en küçük sayıyı
    elde eden kodu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import static org.csystem.util.string.StringUtil.areAllUnique;

class App {
    public static void main(String[] args)
    {
        AreAllUniqueTest.run();
    }
}

class AreAllUniqueTest {
    public static void run()
    {
        for (;;) {
            var str = Console.read("Bir yazı giriniz:");

            Console.writeLine(areAllUnique(str) ? "Tüm karakterler farklı" : "Tekrarlanan karaklterler var");
            if ("elma".equals(str))
                break;
        }
    }
}