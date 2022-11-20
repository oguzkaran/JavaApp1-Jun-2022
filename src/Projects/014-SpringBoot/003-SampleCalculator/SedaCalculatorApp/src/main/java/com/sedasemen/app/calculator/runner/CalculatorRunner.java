package com.sedasemen.app.calculator.runner;

import com.atahanyengin.calculator.bean.BeanName;
import org.csystem.app.calculator.ICalculator;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentSkipListMap;

@Component
public class CalculatorRunner implements ApplicationRunner {
    private final ICalculator m_calculator;

    public CalculatorRunner(@Qualifier(BeanName.CALCULATOR) ICalculator calculator)
    {
        m_calculator = calculator;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        try {
            m_calculator.calculate();
        }
        catch (UnsupportedOperationException ex) {
            Console.Error.writeLine("Exception Message:%s", ex.getMessage());
        }
    }
}
