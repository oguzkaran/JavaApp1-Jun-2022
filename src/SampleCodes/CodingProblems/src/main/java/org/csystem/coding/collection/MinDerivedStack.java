package org.csystem.coding.collection;

import java.util.OptionalInt;
import java.util.Stack;

public class MinDerivedStack extends Stack<Integer> {
    private final Stack<Integer> m_minStack;
    private final int m_size;

    public MinDerivedStack(int size)
    {
        m_minStack = new Stack<>();
        m_size = size;
    }

    @Override
    public Integer push(Integer val) //O(1)
    {
        if (size() == m_size)
            return null;

        var minOpt = min();

        minOpt.ifPresentOrElse(v -> {if (val <= v) m_minStack.push(v);}, () -> m_minStack.push(val));

        return super.push(val);
    }

    @Override
    public Integer pop() //O(1)
    {
        var result = super.pop();
        var minOpt = min();

        if (minOpt.isPresent() && result == minOpt.getAsInt())
            return m_minStack.pop();

        return result;
    }

    public OptionalInt min() //O(1)
    {
        return m_minStack.empty() ? OptionalInt.empty() : OptionalInt.of(m_minStack.pop());
    }
}
