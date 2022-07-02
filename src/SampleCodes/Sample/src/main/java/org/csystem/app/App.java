/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.bitwise.BitwiseUtil;

class App {
    public static void main(String[] args)
    {
        BitwiseUnsignedRightShiftTest.run();
    }
}

class BitwiseUnsignedRightShiftTest {
    public static void run()
    {
        long a = ~(~0L >>> 1);

        while (a != 0) {
            BitwiseUtil.writeBits(a);
            a >>>= 1;
        }
    }
}