package org.csystem.app.service.animalhospital.animal.controller;

import org.csystem.app.service.animalhospital.animal.dto.AnimalExistsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsWithoutOwnerDTO;
import org.csystem.app.service.animalhospital.animal.service.AnimalService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/read/animals")
public class AnimalController {
    private final AnimalService m_animalAppService;

    public AnimalController(AnimalService animalAppService)
    {
        m_animalAppService = animalAppService;
    }

    @GetMapping("animal/id/exists/{id}")
    public AnimalExistsDTO existsAnimalById(@PathVariable("id") int animalId)
    {
        return m_animalAppService.existsAnimalById(animalId);
    }

    @GetMapping("contains/sterile/name")
    public AnimalsDTO findByNameContainsAndSterile(@RequestParam("n") String name)
    {
        return m_animalAppService.findAnimalsByNameContainsAndSterile(name);
    }

    @GetMapping("/find/type")
    public AnimalsWithoutOwnerDTO findByType(@RequestParam("t") String type)
    {
        return m_animalAppService.findAnimalsByType(type);
    }

    @GetMapping("/find/my")
    public AnimalsDTO findByMonthAndYear(int month, int year)
    {
        return m_animalAppService.findAnimalsByMonthAndYear(month, year);
    }
}
