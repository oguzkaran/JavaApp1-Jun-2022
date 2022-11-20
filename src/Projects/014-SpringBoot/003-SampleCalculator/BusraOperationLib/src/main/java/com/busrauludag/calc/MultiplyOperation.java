package com.busrauludag.calc;


import org.csystem.app.calculator.IIntBinaryOperation;
import org.springframework.stereotype.Component;

@Component("com.busrauludag.calc.multiply")
public class MultiplyOperation implements IIntBinaryOperation {
    @Override
    public boolean isValid(char ch)
    {
        return ch == '*';
    }

    @Override
    public int applyAsInt(int left, int right)
    {
        return left * right;
    }
}
