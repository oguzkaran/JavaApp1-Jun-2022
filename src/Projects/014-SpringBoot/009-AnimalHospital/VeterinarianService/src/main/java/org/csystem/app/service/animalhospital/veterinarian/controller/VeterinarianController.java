package org.csystem.app.service.animalhospital.veterinarian.controller;

import org.csystem.app.service.animalhospital.veterinarian.dto.*;
import org.csystem.app.service.animalhospital.veterinarian.service.VeterinarianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("lastname")
    public VeterinariansDTO findByLastName(@RequestParam("n") String lastName)
    {
        return m_veterinarianService.findVeterinariansByLastName(lastName);
    }

    @GetMapping("monthyear")
    public VeterinariansDTO findByMonthAndYear(@RequestParam("m") int month, @RequestParam("y")int year)
    {
        return m_veterinarianService.findVeterinariansByMonthAndYear(month, year);
    }

    @GetMapping("between/year")
    public VeterinariansWithoutCitizenIdDTO findByYearBetween(@RequestParam("begin") int begin, @RequestParam("end")int end)
    {
        return m_veterinarianService.findVeterinariansByYearBetween(begin, end);
    }

    @PostMapping("vet/save")

    public VeterinarianSaveDTO save(@RequestBody VeterinarianSaveDTO veterinarianSave)
    {
        return m_veterinarianService.saveVeterinarian(veterinarianSave);
    }
}
