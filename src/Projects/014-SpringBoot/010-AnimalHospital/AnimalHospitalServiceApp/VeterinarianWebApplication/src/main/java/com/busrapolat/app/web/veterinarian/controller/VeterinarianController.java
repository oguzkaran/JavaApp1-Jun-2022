package com.busrapolat.app.web.veterinarian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @GetMapping("veterinarian/add")
    public String index(Model model)
    {
        return "add";
    }

    @PostMapping("addveterinarian")
    public String addVeterinarian()
    {
        throw new UnsupportedOperationException("TODO:");
    }
}
