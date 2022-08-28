package org.csystem.util.datetime;

@Deprecated(since = "7.0.0")
public class DateTimeException extends RuntimeException  {
    public DateTimeException()
    {}

    public DateTimeException(String msg)
    {
        super(msg);
    }
}
