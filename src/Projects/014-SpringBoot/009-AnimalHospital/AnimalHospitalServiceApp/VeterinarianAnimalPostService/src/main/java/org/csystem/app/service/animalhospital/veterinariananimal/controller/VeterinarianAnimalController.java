package org.csystem.app.service.animalhospital.veterinariananimal.controller;

import com.metemengen.animalhospital.data.entity.jdbc.VeterinarianAnimalSave;
import org.csystem.app.service.animalhospital.veterinariananimal.dto.VeterinarianAnimalSaveDTO;
import org.csystem.app.service.animalhospital.veterinariananimal.service.VeterinarianAnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        var result = m_veterinarianAnimalService.saveVeterinarianAnimal(veterinarianAnimalSaveDTO);
        return ResponseEntity.accepted().body(result);
    }
}
