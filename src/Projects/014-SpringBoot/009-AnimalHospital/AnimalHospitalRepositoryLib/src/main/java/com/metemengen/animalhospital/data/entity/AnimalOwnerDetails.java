package com.metemengen.animalhospital.data.entity;

import java.time.LocalDate;

public class AnimalOwnerDetails {
    public long id;
    public String animalName;
    public String animalType;
    public LocalDate animalBirthDate;
    public String ownerName;
    public String phone;

    public AnimalOwnerDetails()
    {

    }

    public AnimalOwnerDetails(long id, String animalName, String animalType, LocalDate animalBirthDate, String ownerName, String phone)
    {
        this.id = id;
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalBirthDate = animalBirthDate;
        this.ownerName = ownerName;
        this.phone = phone;
    }

}


