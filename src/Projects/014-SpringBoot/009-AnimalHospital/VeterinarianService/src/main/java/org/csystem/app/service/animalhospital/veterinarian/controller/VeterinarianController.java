package org.csystem.app.service.animalhospital.veterinarian.controller;

import org.csystem.app.service.animalhospital.veterinarian.dto.CountDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.csystem.app.service.animalhospital.veterinarian.service.VeterinarianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vets")
public class VeterinarianController {
    private final VeterinarianService m_veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService)
    {
        m_veterinarianService = veterinarianService;
    }

    @GetMapping("count")
    public CountDTO count()
    {
        return m_veterinarianService.countVeterinarians();
    }

    @GetMapping("vet/diploma")
    public ResponseEntity<VeterinarianDTO> findByDiplomaNo(@RequestParam("no") long number)
    {
        return ResponseEntity.of(m_veterinarianService.findVeterinarianByDiplomaNo(number));
    }

    @GetMapping("vet/lastname")
    public VeterinariansDTO findByLastName(@RequestParam("n") String lastName)
    {
        return m_veterinarianService.findVeterinariansByLastName(lastName);
    }
}
