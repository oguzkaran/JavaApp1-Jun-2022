package org.csystem.app.factory;

import org.csystem.util.iterable.IntRange;
import org.csystem.util.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameWithIndexFactory {
    private final List<Pair<Integer, String>> m_nameList;

    public NameWithIndexFactory()
    {
        m_nameList = List.of(Pair.of(1, "Eray Taşay"), Pair.of(2, "Atahan Yengin"), Pair.of(3, "Barış Er"),
                Pair.of(4, "Can Kartal"),  Pair.of(5, "Ceyhun Ersin Eğrek"), Pair.of(6, "Deniz Öğüt"),
                Pair.of(7, "Furkan Kaya"), Pair.of(8, "Kudret Batuhan"), Pair.of(9, "Nuri Can Öztürk"), Pair.of(10, "Seda Semen"),
                Pair.of(11, "Şeyma Kurtbaş"), Pair.of(12, "Turgut Can Özdemir"));
    }

    public List<Pair<Integer, String>> getNames(Random r, int n)
    {
        var names = new ArrayList<Pair<Integer, String>>();
        var size = m_nameList.size();

        IntRange.of(0, n).forEach(i -> names.add(m_nameList.get(r.nextInt(size))));

        return names;
    }
}

