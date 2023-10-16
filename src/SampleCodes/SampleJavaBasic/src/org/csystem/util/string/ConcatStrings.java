/*----------------------------------------------------------------
	FILE		: ConcatStrings.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 21.05.2023

	ConcatStrings class to concat list of strings

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.string;

import java.util.ArrayList;

public class ConcatStrings {
    private final ArrayList m_strList = new ArrayList();

    public void add(String str)
    {
        m_strList.add(str);
    }

    public String concat()
    {
        if (m_strList.isEmpty())
            return "";

        String str = "";

        for (Object o : m_strList) {
            String s = (String)o;

            str += s;
        }

        return str;
    }

    public String concat(String delimiter)
    {
        if (m_strList.isEmpty())
            return "";

        String str = "";

        for (Object o : m_strList) {
            String s = (String)o;

            str += s + delimiter;
        }

        return str.substring(0, str.length() - delimiter.length());
    }

}