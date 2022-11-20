package com.bariser.calculator.operation;

import org.csystem.app.calculator.IIntBinaryOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("com.bariser.calculator.operation.multiply")
@Scope("prototype")
public class MultiplyOperation implements IIntBinaryOperation {
    //...
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
