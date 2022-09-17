package org.csystem.app.factory;

import org.csystem.util.iterable.IntRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameFactory {
    private final List<String> m_stringList;

    public NameFactory()
    {
        m_stringList = List.of("Eray Taşay", "Atahan Yengin", "Barış Er", "Can Kartal", "Ceyhun Ersin Eğrek",
                "Deniz Öğüt", "Furkan Kaya", "Kudret Batuhan", "Nuri Can Öztürk", "Seda Semen", "Şeyma Kurtbaş", "Turgut Can Özdemir");
    }

    public List<String> getNames(Random r, int n)
    {
        var names = new ArrayList<String>();
        var size = m_stringList.size();

        IntRange.of(0, n).forEach(i -> names.add(m_stringList.get(r.nextInt(size))));

        return names;
    }
}

