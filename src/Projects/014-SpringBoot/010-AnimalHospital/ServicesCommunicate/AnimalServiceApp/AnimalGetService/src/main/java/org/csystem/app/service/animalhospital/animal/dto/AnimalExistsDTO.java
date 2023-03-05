package org.csystem.app.service.animalhospital.animal.dto;

import java.time.LocalDate;

public class AnimalExistsDTO {
    public boolean exists;

    public AnimalExistsDTO(boolean exists)
    {
        this.exists = exists;
    }
}
