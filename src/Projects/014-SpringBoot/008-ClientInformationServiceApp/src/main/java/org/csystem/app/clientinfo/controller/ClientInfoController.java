package org.csystem.app.clientinfo.controller;

import org.csystem.app.clientinfo.view.ClientDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@Scope("prototype")
@RequestMapping("api/client")
public class ClientInfoController {
    private final HttpServletRequest m_httpServletRequest;
    private final LocalDateTime m_localDateTime;

    public ClientInfoController(HttpServletRequest httpServletRequest, LocalDateTime localDateTime)
    {
        m_httpServletRequest = httpServletRequest;
        m_localDateTime = localDateTime;
    }

    @GetMapping("info")
    public ClientDTO clientInfo()
    {
        //...
        return new ClientDTO()
                .setHost(m_httpServletRequest.getRemoteHost())
                .setPort(m_httpServletRequest.getRemotePort())
                .setLocalHost(m_httpServletRequest.getLocalAddr())
                .setLocalPort(m_httpServletRequest.getLocalPort())
                .setDateTime(m_localDateTime);
    }
}

/*
    {
        "host": "192.168.1.111",
        "port": 13566,
        "localHost": "192.168.1.111",
        "localPort": 50501
    }
*/