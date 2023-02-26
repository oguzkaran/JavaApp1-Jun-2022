package org.csystem.app.service.animalhospital.owner.controller;

import org.csystem.app.service.animalhospital.owner.dto.OwnersDTO;
import org.csystem.app.service.animalhospital.owner.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/read/owners")
public class OwnerController {
    private final OwnerService m_ownerService;

    public OwnerController(OwnerService ownerService)
    {
        m_ownerService = ownerService;
    }

    @GetMapping("/find/phone")
    public OwnersDTO findByPhone(@RequestParam("p") String phone)
    {
        return m_ownerService.findOwnersByPhone(phone);
    }
}
