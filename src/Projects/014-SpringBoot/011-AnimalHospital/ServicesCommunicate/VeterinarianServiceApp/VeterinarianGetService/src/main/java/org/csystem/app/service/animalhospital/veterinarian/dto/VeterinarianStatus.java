package org.csystem.app.service.animalhospital.veterinarian.dto;

public class VeterinarianStatus {
    public VeterinarianStatusInfo status;

    public VeterinarianStatus(String message, long diplomaNo)
    {
        status = new VeterinarianStatusInfo();

        status.message = message;
        status.diplomaNo = diplomaNo;
    }
}
