package org.csystem.app.clientinfo.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ClientDTO {
    private String m_host;
    private int m_port;
    private String m_localHost;
    private int m_localPort;
    private LocalDateTime m_dateTime;

    public String getHost()
    {
        return m_host;
    }

    public ClientDTO setHost(String host)
    {
        m_host = host;

        return this;
    }

    public int getPort()
    {
        return m_port;
    }

    public ClientDTO setPort(int port)
    {
        m_port = port;

        return this;
    }

    @JsonProperty("localAddr")
    public String getLocalHost()
    {
        return m_localHost;
    }

    public ClientDTO setLocalHost(String localHost)
    {
        m_localHost = localHost;

        return this;
    }

    public int getLocalPort()
    {
        return m_localPort;
    }

    public ClientDTO setLocalPort(int localPort)
    {
        m_localPort = localPort;

        return this;
    }

    @JsonFormat(pattern = "dd/MM/yyyy kk:mm:ss")
    public LocalDateTime getDateTime()
    {
        return m_dateTime;
    }

    @JsonFormat(pattern = "dd/MM/yyyy kk:mm:ss")
    public ClientDTO setDateTime(LocalDateTime dateTime)
    {
        m_dateTime = dateTime;

        return this;
    }
}
