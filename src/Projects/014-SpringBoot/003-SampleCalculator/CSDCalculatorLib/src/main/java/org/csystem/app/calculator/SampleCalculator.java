package org.csystem.app.calculator;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SampleCalculator {
    private final Collection<IIntBinaryOperation> m_intBinaryOperations;

    private void throwUnsupportedOperationException(char op)
    {
        throw new UnsupportedOperationException("Unsupported Operation:" + op);
    }

    public SampleCalculator(Collection<IIntBinaryOperation> intBinaryOperations)
    {
        m_intBinaryOperations = intBinaryOperations;
    }

    public void calculate(int a, int b, char op)
    {
        m_intBinaryOperations.stream()
                .filter(bo -> bo.isValid(op))
                .findFirst()
                .ifPresentOrElse(bo -> Console.writeLine("%d %c %d = %d", a, op, b, bo.applyAsInt(a, b)),
                        () -> throwUnsupportedOperationException(op));
    }

    public void calculateAll(int a, int b, char op)
    {
        m_intBinaryOperations.stream()
                .filter(bo -> bo.isValid(op))
                .forEach(bo -> Console.writeLine("%d %c %d = %d", a, op, b, bo.applyAsInt(a, b)));
    }
}
