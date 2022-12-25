package org.csystem.app.service.animalhospital.veterinarian.controller;

import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianSaveDTO;
import org.csystem.app.service.animalhospital.veterinarian.service.VeterinarianService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/update/vets")
public class VeterinarianController {
    private final VeterinarianService m_veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService)
    {
        m_veterinarianService = veterinarianService;
    }

    @PostMapping("vet/save")
    public VeterinarianSaveDTO save(@RequestBody VeterinarianSaveDTO veterinarianSave)
    {
        return m_veterinarianService.saveVeterinarian(veterinarianSave);
    }
}
