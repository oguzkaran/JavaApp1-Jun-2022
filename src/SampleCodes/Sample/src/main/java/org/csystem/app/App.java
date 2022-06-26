/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.util.Scanner;

class App {
    public static void main(String[] args)
    {
        var kb = new Scanner(System.in);

        for (int i = 0; i < 5; ++i) {
            var s = kb.nextLine();

            System.out.println(s.toUpperCase());
        }

        System.err.println("Tekrar yapmıyorum");
        System.out.println("Tekrar yapıyor musunuz?");
    }
}
