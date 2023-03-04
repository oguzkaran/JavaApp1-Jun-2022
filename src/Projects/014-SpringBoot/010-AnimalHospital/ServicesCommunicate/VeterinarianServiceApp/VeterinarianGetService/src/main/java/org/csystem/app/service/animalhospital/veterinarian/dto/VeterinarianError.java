package org.csystem.app.service.animalhospital.veterinarian.dto;

public class VeterinarianError {
    public String message;
    public int status;

    public VeterinarianError(String message, int status)
    {
        this.message = message;
        this.status = status;
    }
}
