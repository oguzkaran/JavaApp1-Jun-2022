package com.metemengen.animalhospital.data.entity;

import java.time.LocalDate;

public class AnimalOwner {
    public String name;
    public String type;
    public LocalDate birthDate;
    public boolean sterile;

    public AnimalOwner(String name, String type, LocalDate birthDate, boolean sterile)
    {
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.sterile = sterile;
    }
}
