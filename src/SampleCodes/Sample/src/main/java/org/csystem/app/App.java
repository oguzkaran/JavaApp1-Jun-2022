/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.collection.CSDVectorCapacityFactor;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var vector = new CSDVectorCapacityFactor<Integer>(10, 5.6);

        for (int i = 0; i < 12; ++i)
            vector.add(i * 10);

        Console.writeLine("Capacity:%d", vector.capacity());
    }
}

