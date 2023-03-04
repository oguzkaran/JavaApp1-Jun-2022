package org.csystem.app.service.animalhospital.animal.controller;

import com.metemengen.animalhospital.data.entity.orm.dto.AnimalSaveDTO;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import org.csystem.app.service.animalhospital.animal.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/update/animals")
public class AnimalController {
    private final AnimalService m_animalService;

    public AnimalController(AnimalService animalService)
    {
        m_animalService = animalService;
    }

    @PostMapping("animal/owner/save")
    public AnimalWithOwnerSaveDTO saveWithOwner(@RequestBody AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        return m_animalService.saveAnimalWithOwner(animalWithOwnerSaveDTO);
    }

    @PostMapping("animal/save")
    public ResponseEntity<AnimalSaveDTO> save(@RequestBody AnimalSaveDTO animalSaveDTO)
    {
        var animal = m_animalService.saveAnimal(animalSaveDTO);

        return animal.id != 0 ? ResponseEntity.ok(animal) : ResponseEntity.status(HttpStatus.NO_CONTENT).body(animal);
    }
}


