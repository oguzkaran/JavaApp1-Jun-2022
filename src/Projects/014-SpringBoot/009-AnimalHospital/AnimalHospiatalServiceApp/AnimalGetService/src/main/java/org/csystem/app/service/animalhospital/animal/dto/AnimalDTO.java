package org.csystem.app.service.animalhospital.animal.dto;

import com.metemengen.animalhospital.data.entity.Owner;

import java.time.LocalDate;

public class AnimalDTO { //POJO (Plain Old Java Object)
    public int id;
    public String name;
    public String type;
    public LocalDate birthDate;
    public boolean sterile;
}
