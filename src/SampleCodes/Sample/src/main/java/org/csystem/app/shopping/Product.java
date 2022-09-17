package org.csystem.app.shopping;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private int m_id;
    private String m_name;
    private LocalDate m_expiryDate;
    private double m_stock;
    private BigDecimal m_cost;
    private BigDecimal m_unitPrice;

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public LocalDate getExpiryDate()
    {
        return m_expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate)
    {
        m_expiryDate = expiryDate;
    }

    public double getStock()
    {
        return m_stock;
    }

    public void setStock(double stock)
    {
        m_stock = stock;
    }

    public BigDecimal getCost()
    {
        return m_cost;
    }

    public void setCost(BigDecimal cost)
    {
        m_cost = cost;
    }

    public BigDecimal getUnitPrice()
    {
        return m_unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        m_unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Product p && p.m_id == m_id;
    }

    @Override
    public String toString()
    {
        return "...";
    }
}
