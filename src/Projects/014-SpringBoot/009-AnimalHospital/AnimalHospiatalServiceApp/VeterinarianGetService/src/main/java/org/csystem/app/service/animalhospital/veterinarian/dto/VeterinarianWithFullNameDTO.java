package org.csystem.app.service.animalhospital.veterinarian.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class VeterinarianWithFullNameDTO {
    public long diplomaNo;
    public String fullName;

    @JsonFormat(pattern = "dd/MM/yyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate registerDate;
}
