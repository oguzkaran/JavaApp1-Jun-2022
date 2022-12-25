package org.csystem.app.service.animalhospital.veterinarian.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class VeterinarianWithoutCitizenIdDTO {
    public long diplomaNo;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;

    public String lastName;

    @JsonFormat(pattern = "dd/MM/yyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate registerDate;


}
