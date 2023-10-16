package com.dilekozdil.app.employee;

public class ProjectWorker extends Worker {
    private String m_projectName;
    private double m_extraFee;

    //...

    public String getProjectName()
    {
        return m_projectName;
    }

    public void setProjectName(String projectName)
    {
        //...
        m_projectName = projectName;
    }

    public double getExtraFee()
    {
        return m_extraFee;
    }

    public void setExtraFee(double extraFee)
    {
        //...
        m_extraFee = extraFee;
    }
    public double calculateInsurancePayment()
    {
        return super.calculateInsurancePayment() + m_extraFee * 30;
    }
}
