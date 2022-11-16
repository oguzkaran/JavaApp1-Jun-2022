package org.csystem.coding.collection;

import java.util.OptionalInt;
import java.util.Stack;

public class MinWrapperStack {
    private final Stack<Integer> m_minStack;
    private final Stack<Integer> m_stack;
    private final int m_size;

    public MinWrapperStack(int size)
    {
        m_stack = new Stack<>();
        m_minStack = new Stack<>();
        m_size = size;
    }

    public OptionalInt push(Integer val) //O(1)
    {
        if (m_stack.size() == m_size)
            return OptionalInt.empty();

        var minOpt = min();

        minOpt.ifPresentOrElse(v -> {if (val <= v) m_minStack.push(v);}, () -> m_minStack.push(val));

        return OptionalInt.of(m_stack.push(val));
    }


    public int pop() //O(1)
    {
        var result = m_stack.pop();
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
