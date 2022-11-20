package org.csystem.app.calculator;

import java.util.function.IntBinaryOperator;

public interface IIntBinaryOperation extends IntBinaryOperator {
    boolean isValid(char ch);
}
