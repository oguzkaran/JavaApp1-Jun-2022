/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.collection.CSDArrayListNotNullable;
import org.csystem.util.console.Console;
import org.csystem.util.iterable.IntRange;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Vector;

class App {
    public static void main(String[] args)
    {
        var r = new Random();
        var vector = new Vector<String>();


        IntRange.of(0, 10).forEach(i -> vector.add(r.nextBoolean() ? null : StringUtil.getRandomTextTR(r, r.nextInt(5, 10))));

        vector.forEach(Console::writeLine);

        var list = new CSDArrayListNotNullable<>();
        list.addAll(vector);

        list.forEach(Console::writeLine);
    }
}

