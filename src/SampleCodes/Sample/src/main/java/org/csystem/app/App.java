/*----------------------------------------------------------------------------------------------------------------------
    static sınıflar static elemanlar olduklarından "import static single type declaration" bildirimi ilem niteliksiz
    (unqualified) olarak kullanılabilir. Ancak bu durumda "top-level" sınıf gibi eriişildiğinden okunabilirliğin
    bozulmamasına dikkat edilmelidir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import static org.csystem.app.A.B;

class App {
    public static void main(String[] args)
    {
        var b = new B();
        //...
    }
}

class A {
    public static class B {
        private void foo()
        {
            Console.writeLine("B.foo");
        }

        private int m_x;

        public int getX()
        {
            return m_x;
        }

        public void setX(int x)
        {
            m_x = x;
        }

        public void bar()
        {
            Console.writeLine("B.bar");
        }

        public static void tar()
        {
            Console.writeLine("B.tar");
        }
    }


}

