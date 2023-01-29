package org.csystem.app.service.animalhospital.animal.controller;


import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import org.csystem.app.service.animalhospital.animal.service.AnimalService;
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
}
