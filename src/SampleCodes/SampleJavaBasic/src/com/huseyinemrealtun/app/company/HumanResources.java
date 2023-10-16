package com.huseyinemrealtun.app.company;

import com.yusuflale.company.Employee;

public class HumanResources {
    //...
    public void payInsurance(Employee employee)
    {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("Citizen Id:%s%n", employee.getCitizenId());
        System.out.printf("Name:%s%n", employee.getName());
        System.out.printf("Insurance Payment:%f%n", employee.calculateInsurancePayment());
        //...
        System.out.println("...");
        System.out.println("------------------------------------------------------------------");
    }
}
