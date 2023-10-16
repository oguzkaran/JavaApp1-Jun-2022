/*----------------------------------------------------------------------------------------------------------------------
    Aşağıda bildirilen Date sınıfını açıklamalara göre yazınız
    Açıklamalar:
        - Sınıf bir tarihi temsil edecektir (gün, ay ve yıl)

        - JavaSE'nin veya başka bir kütüphanenin tarih zaman işlemlerine ilişkin sınıfları ve metotları kullanılmayacaktır

        - Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz

        - Sınıf geçersiz tarih durumunu kontrol edecektir. Geçersizlik durumunda yazılmış olan DateTimeException fırlatacaktır

        - Sınıfın DayOfWeek ve Month enum class'larını kullanmaktadır. enum class'ların sabitlerini değiştirmeden istediğiniz
        eklemeyi yapabilirsiniz

        - Daha önce yazılmış olan DateUtil sınıfı içerisinde metotlardan yararlanabilirsiniz. Ancak sınıf DateUtil
        sınıfını kullanmayacaktır

        - Ay bilgisini değer olarak alan veya değer olarak geri döndüren metotlar içinm değer [1, 12] aralığında olacaktır

        - Sınıfa ilişkin test kodlarını da yazınız
-----------------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------
	FILE		: Date.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 01.04.2023

	Date class that represents a date

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.util.datetime;

public class Date {
    public Date(int day, int monthValue, int year)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public Date(int day, Month month, int year)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getDay()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setDay(int day)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getMonthValue()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setMonthValue(int monthValue)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public Month getMonth()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setMonth(Month month)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public int getYear()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public void setYear(int year)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public DayOfWeek getDayOfWeek()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public String getDayOfWeekEN()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public String getDayOfWeekTR()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public boolean isLeapYear()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public boolean isWeekday()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public boolean isWeekend()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    public String toString()
    {
        throw new UnsupportedOperationException("TODO -> 01/04/2023");
    }

    public String toString(char delimiter)
    {
        throw new UnsupportedOperationException("TODO -> if delinmiter is . then 01.04.2023");
    }

    public String toLongDateStringTR()
    {
        throw new UnsupportedOperationException("TODO -> 1 Nisan 2023 Cumartesi");
    }

    public String toLongDateStringEN()
    {
        throw new UnsupportedOperationException("TODO -> 1st April 2023 Saturday ");
    }

    public String toShortDateStringTR()
    {
        throw new UnsupportedOperationException("TODO -> 1 Nisan 2023");
    }

    public String toShortDateStringEN()
    {
        throw new UnsupportedOperationException("TODO -> 1st April 2023");
    }
}
