package org.csystem.app.service.animalhospital.veterinarian.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class VeterinarianStatusDTO {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public long diplomaNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String citizenId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String lastName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate registerDate;
    
    public boolean found = true;

    public VeterinarianStatusDTO()
    {

    }

    public VeterinarianStatusDTO(boolean found)
    {
        this.found = found;
    }

    //...
}
