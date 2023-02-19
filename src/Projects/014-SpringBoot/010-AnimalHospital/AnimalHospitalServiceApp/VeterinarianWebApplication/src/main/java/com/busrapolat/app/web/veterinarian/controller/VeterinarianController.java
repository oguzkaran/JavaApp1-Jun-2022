package com.busrapolat.app.web.veterinarian.controller;

import com.busrapolat.app.web.veterinarian.model.VeterinarianModel;
import com.busrapolat.app.web.veterinarian.model.VeterinarianSaveModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @GetMapping("/veterinarian")
    public String veterinarianForm(Model model)
    {
        model.addAttribute("veterinarian", new VeterinarianSaveModel());

        return "add";
    }

    @PostMapping("/addveterinarian")
    public String veterinarianSubmit(Model model, @ModelAttribute VeterinarianSaveModel veterinarian)
    {
        model.addAttribute("veterinarian", veterinarian);
        //...

        return "result";
    }

    @GetMapping("/all")
    public String findAll(Model model)
    {
        model.addAttribute("veterinarians", new ArrayList<VeterinarianModel>());

        //...

        return "all";
    }
}
