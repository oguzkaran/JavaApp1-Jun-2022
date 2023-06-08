package com.metemengen.animalhospital.data.entity.orm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AnimalOwnerDetails {
    public String animalName;
    public String animalType;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate animalBirthDate;

    public String ownerName;

    public String phone;

    public AnimalOwnerDetails(String animalName, String animalType, LocalDate animalBirthDate, String ownerName, String phone)
    {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalBirthDate = animalBirthDate;
        this.ownerName = ownerName;
        this.phone = phone;
    }

}


