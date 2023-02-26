package com.busrapolat.app.web.veterinarian.controller;

import com.busrapolat.app.web.veterinarian.model.VeterinarianSaveModel;
import com.busrapolat.app.web.veterinarian.service.VeterinarianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/veterinarians")
public class VeterinarianController {

    private final VeterinarianService m_veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService)
    {
        m_veterinarianService = veterinarianService;
    }

    @GetMapping("/veterinarian")
    public String veterinarianForm(Model model)
    {
        model.addAttribute("veterinarian", new VeterinarianSaveModel());

        return "add";
    }

    @PostMapping("/addveterinarian")
    public String veterinarianSubmit(Model model, @ModelAttribute VeterinarianSaveModel veterinarian)
    {
        m_veterinarianService.saveVeterinarian(veterinarian);
        model.addAttribute("veterinarian", veterinarian);

        return "result";
    }

    @GetMapping("/all")
    public String findAll(Model model)
    {
        model.addAttribute("veterinarians", m_veterinarianService.findAllVeterinariansWithFullName().veterinarians);
        //...

        return "all";
    }
}
