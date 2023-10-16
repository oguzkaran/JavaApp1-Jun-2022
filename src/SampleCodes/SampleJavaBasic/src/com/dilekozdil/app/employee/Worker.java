package com.dilekozdil.app.employee;

import com.yusuflale.company.Employee;

public class Worker extends Employee {
    private double m_feePerHour;
    private int m_hourPerDay;

    //...


    public double getFeePerHour()
    {
        return m_feePerHour;
    }

    public void setFeePerHour(double feePerHour)
    {
        //...
        m_feePerHour = feePerHour;
    }

    public int getHourPerDay()
    {
        return m_hourPerDay;
    }

    public void setHourPerDay(int hourPerDay)
    {
        //...
        m_hourPerDay = hourPerDay;
    }

    public double calculateInsurancePayment()
    {
        return m_feePerHour * m_hourPerDay * 30;
    }
}