package org.csystem.app.service.animalhospital.animal.controller;

import org.csystem.app.service.animalhospital.animal.dto.AnimalsDTO;
import org.csystem.app.service.animalhospital.animal.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.csystem.util.collection.CollectionUtil.toList;

@RestController()
@RequestMapping("api/read/animals")
public class AnimalController {
    private final AnimalService m_animalAppService;

    public AnimalController(AnimalService animalAppService)
    {
        m_animalAppService = animalAppService;
    }

    @GetMapping("contains/sterile/name")
    public AnimalsDTO findByNameContainsAndSterile(@RequestParam("n") String name)
    {
        return m_animalAppService.findAnimalsByNameContainsAndSterile(name);
    }

    @GetMapping("/find/type")
    public AnimalsDTO findByType(String type)
    {
        return m_animalAppService.findAnimalsByType(type);
    }

    @GetMapping("/find/my")
    public AnimalsDTO findByMonthAndYear(int month, int year)
    {
        return m_animalAppService.findAnimalsByMonthAndYear(month, year);
    }
}
