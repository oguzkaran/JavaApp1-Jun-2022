/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte enlargaCapacity metodu private olduğundan normal şartlarda public bir metot gibi argüman kontrolü
    yapılmaz. Çünkü zaten private metot programcı tarafından uygun argümanlarla çağrılır. Fakat bu durumunda programcı
    sınıfı yazarken hata yapma olasılığına karşılık enlargeCapacity metodunun argüman değerlerini kontrol edebilir. Hatta
    böylesi durumlar kritikse kontrol etmelidir. İşte bu test basit olarak assert deyimi ile yapılabilir. İleride göreceğimizi
    söylediğimiz assert deyimlerinin nihai üründen kaldırılması durumu assert deyimlerinin ürünü size olarak büyütmesini
    engelleyecektir. Aşağıdaki kodda -a kaldırılsa da assert deyimleri orada kalır ancak görmezden gelinir. add metodunda
    * ile belirtilen çağrıyı enlargeCapacity(m_elems.length * 2); biçiminde değiştirerek ve trimToSize metosunda ** ile
    belirtilen if deyimini kaldırarak, JVM'i -ea ile çalışıtırp sonucu gözlemleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Arrays;

class App {
    public static void main(String[] args)
    {
        var list = new IntList(5);

        Console.writeLine("Capacity:%d", list.capacity());
        Console.writeLine("Size:%d", list.size());

        for (int i = 0; i < 11; ++i)
            list.add(i * 10);

        Console.writeLine("Capacity:%d", list.capacity());
        Console.writeLine("Size:%d", list.size());

        list.trimToSize();

        Console.writeLine("Capacity:%d", list.capacity());
        Console.writeLine("Size:%d", list.size());

        list.clear();

        Console.writeLine("Capacity:%d", list.capacity());
        Console.writeLine("Size:%d", list.size());

        list.trimToSize();

        Console.writeLine("Capacity:%d", list.capacity());
        Console.writeLine("Size:%d", list.size());

        list.add(10);
    }
}

class IntList {
    private static final int DEFAULT_CAPACITY = 10;
    private int [] m_elems;
    private int m_index;

    private void enlargeCapacity(int newCapacity)
    {
        assert newCapacity != 0 : "newCapacity can not be zero";
        assert newCapacity >= m_index : newCapacity + ", " + m_index;
        m_elems = Arrays.copyOf(m_elems, newCapacity);
    }

    public IntList()
    {
        m_elems = new int[DEFAULT_CAPACITY];
    }

    public IntList(int initialCapacity)
    {
        m_elems = new int[initialCapacity];
    }

    public void add(int value)
    {
        if (m_elems.length == m_index)
            enlargeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2); //*

        m_elems[m_index++] = value;
    }

    public int get(int index)
    {
        //...
        return m_elems[index];
    }

    public void clear()
    {
        m_index = 0;
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public int size()
    {
        return m_index;
    }

    public void trimToSize()
    {
        if (m_index != 0) //**
            enlargeCapacity(m_index);
    }
}
