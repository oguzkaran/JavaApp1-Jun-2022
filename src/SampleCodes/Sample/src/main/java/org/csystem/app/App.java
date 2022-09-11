/*----------------------------------------------------------------------------------------------------------------------
    Liste tarzı collection sınıflar elemanları arasında öncelik-sonralık ilişkisi olan collection sınıflardır. Bu sınıflar
    convention List<E> arayüzünü destekler. List<E> arayüzü Collection<E> arayüzünden türetilmiştir. List<E> arayüzünün
    Collection<E> arayüzünden gelen metotları dışında önemli iki metodu indexOf ve get metotlarıdır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.generator.IntGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var r = new Random();
        var iLinkedList = new LinkedList<Integer>();

        IntGenerator.of(r, 10, 0, 99).forEach(iLinkedList::add);

        iLinkedList.forEach(a -> Console.write("%d ", a));
        Console.writeLine();
        var iList = new ArrayList<Integer>(iLinkedList);

        iList.add(400);
        iList.addAll(iLinkedList);

        iList.forEach(a -> Console.write("%d ", a));
        Console.writeLine();
    }
}
