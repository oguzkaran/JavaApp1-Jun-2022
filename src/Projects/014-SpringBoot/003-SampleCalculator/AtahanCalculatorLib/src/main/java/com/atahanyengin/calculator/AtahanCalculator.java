package com.atahanyengin.calculator;

import com.atahanyengin.calculator.bean.BeanName;
import org.csystem.app.calculator.ICalculator;
import org.csystem.app.calculator.SampleCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(BeanName.CALCULATOR)
public class AtahanCalculator implements ICalculator {
    private final SampleCalculator m_sampleCalculator;

    @Value("${atahan.calculator.left:0}")
    private int m_left;

    @Value("${atahan.calculator.right:0}")
    private int m_right;

    @Value("${atahan.calculator.op:+}")
    private char m_op;

    public AtahanCalculator(SampleCalculator sampleCalculator)
    {
        m_sampleCalculator = sampleCalculator;
    }

    @Override
    public void calculate() throws Exception
    {
        System.out.println("Atahan Calculator:");
        m_sampleCalculator.calculate(m_left, m_right, m_op);
        System.out.println("-------------------------------");
        m_sampleCalculator.calculateAll(m_left, m_right, m_op);
    }
}
