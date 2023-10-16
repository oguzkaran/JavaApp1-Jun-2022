package org.csystem.app.text.findincurly;

public class FindTextInCurly {
    private String m_text;
    private String m_result;
    private boolean m_valid;

    public FindTextInCurly(String text)
    {
        m_text = text;
        m_result = m_text;
        m_valid = true;
    }

    public String getText()
    {
        return m_text;
    }

    public void setText(String text)
    {
        m_text = text;
    }

    public String getResult()
    {
        return m_result;
    }

    public boolean isValid()
    {
        return m_valid;
    }

    public void parse()
    {
        for (;;) {
            int open = m_result.indexOf('{');
            int close = m_result.lastIndexOf('}');

            if (open == -1 && close != -1 || open > close) {
                m_valid = false;
                break;
            }

            if (close == -1)
                break;

            m_result = m_result.substring(open + 1, close);
        }
    }

    public String toString()
    {
        return String.format("%s", m_valid ? m_result : "");
    }
}
