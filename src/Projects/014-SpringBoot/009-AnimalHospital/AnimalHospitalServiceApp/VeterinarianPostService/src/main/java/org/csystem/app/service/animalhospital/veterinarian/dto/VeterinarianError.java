package org.csystem.app.service.animalhospital.veterinarian.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class VeterinarianError {
    public String message;
    public int status;
    @JsonFormat(pattern = "dd/MM/yyyy kk:mm:ss", shape = JsonFormat.Shape.STRING)
    public LocalDateTime dateTime = LocalDateTime.now();

    public VeterinarianError(String message, int status)
    {
        this.message = message;
        this.status = status;
    }
}
