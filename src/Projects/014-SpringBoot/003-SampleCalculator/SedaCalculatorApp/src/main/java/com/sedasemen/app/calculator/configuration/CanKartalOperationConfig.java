package com.sedasemen.app.calculator.configuration;

import org.csystem.app.calculator.IIntBinaryOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.com.cankartal.calculator.MultiplyOperation;

@Configuration
public class CanKartalOperationConfig {
    @Bean
    public IIntBinaryOperation createCanKartalOperation()
    {
        return new MultiplyOperation();
    }
}
