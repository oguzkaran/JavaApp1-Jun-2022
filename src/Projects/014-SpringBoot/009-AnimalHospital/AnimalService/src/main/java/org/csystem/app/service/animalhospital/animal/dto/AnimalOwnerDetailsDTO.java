package org.csystem.app.service.animalhospital.animal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AnimalOwnerDetailsDTO {
    public String animalName;
    public String animalType;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate animalBirthDate;
    public String ownerName;
    public String phone;
}
