/*----------------------------------------------------------------------------------------------------------------------
    org-csystem-util-math kütüphanesinin 6.0.0 versiyonunda AnalyticalCircle sınıfının (ve diğer sınıfların da) equals
    metodu override edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.factory.RandomCircleFactory;
import org.csystem.util.console.Console;
import org.csystem.util.math.geometry.AnalyticalCircle;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var factory = new RandomCircleFactory(new Random(), -10, 10);

        var circles = factory.getCircles(Console.readInt("Bir sayı giriniz:"));

        circles.forEach(Console::writeLine);

        var r = Console.readDouble("Yarıçapı giriniz:");
        var x = Console.readDouble("x'i giriniz:");
        var y = Console.readDouble("y'yi giriniz:");
        var ac = new AnalyticalCircle(r, x, y);
        var index = circles.indexOf(ac);

        if (index != -1)
            Console.writeLine("%s çemberi %d.indekste bulundu:", ac, index);
        else
            Console.writeLine("%s çemberi bulunamadı:", ac);

    }
}

