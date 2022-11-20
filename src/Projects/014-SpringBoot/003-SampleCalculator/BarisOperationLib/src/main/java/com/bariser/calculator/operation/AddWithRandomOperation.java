package com.bariser.calculator.operation;

import org.csystem.app.calculator.IIntBinaryOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.random.RandomGenerator;

@Component("com.bariser.calculator.operation.addwithrandom")
@Scope("prototype")
public class AddWithRandomOperation implements IIntBinaryOperation {
    private final RandomGenerator m_randomGenerator;

    @Value("${com.bariser.calculator.operation.random.min:0}")
    private int m_min;

    @Value("${com.bariser.calculator.operation.random.bound:100}")
    private int m_max;


    public AddWithRandomOperation(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    @Override
    public boolean isValid(char ch)
    {
        return ch == '+';
    }

    @Override
    public int applyAsInt(int left, int right)
    {
        return left + right + m_randomGenerator.nextInt(m_min, m_max + 1);
    }
}
