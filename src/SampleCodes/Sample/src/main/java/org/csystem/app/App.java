/*----------------------------------------------------------------------------------------------------------------------
    Method Reference:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.function.IntBinaryOperator;

class App {
    public static void main(String[] args)
    {
        IntBinaryOperator bop = Operation::add;
    }
}

class Operation {
    public static int add(int a, int b)
    {
        return a + b;
    }
}
