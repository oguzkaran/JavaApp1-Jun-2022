package org.csystem.app.service.animalhospital.veterinariananimal.controller;

import org.csystem.app.service.animalhospital.veterinariananimal.dto.VeterinarianAnimalSaveDTO;
import org.csystem.app.service.animalhospital.veterinariananimal.service.VeterinarianAnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animalhospital/")
public class VeterinarianAnimalController {
    private final VeterinarianAnimalService m_veterinarianAnimalService;

    public VeterinarianAnimalController(VeterinarianAnimalService veterinarianAnimalService)
    {
        m_veterinarianAnimalService = veterinarianAnimalService;
    }

    @PostMapping("/vetan/save")
    public ResponseEntity<Boolean> saveVeterinarianAnimal(@RequestBody VeterinarianAnimalSaveDTO veterinarianAnimalSaveDTO)
    {
        return ResponseEntity.accepted().body(m_veterinarianAnimalService.saveVeterinarianAnimal(veterinarianAnimalSaveDTO));
    }
}
