package org.csystem.app.service.animalhospital.veterinarian.controller;

import com.karandev.util.data.service.DataServiceException;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianError;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianSaveDTO;
import org.csystem.app.service.animalhospital.veterinarian.service.VeterinarianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/update/vets")
public class VeterinarianController {
    private final VeterinarianService m_veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService)
    {
        m_veterinarianService = veterinarianService;
    }

    @PostMapping("vet/save")
    public ResponseEntity<Object> save(@RequestBody VeterinarianSaveDTO veterinarianSave)
    {
        ResponseEntity<Object> result;

        try {
            result = ResponseEntity.ok(m_veterinarianService.saveVeterinarian(veterinarianSave));
        }
        catch (DataServiceException ignore) {
            result = ResponseEntity.internalServerError().body(new VeterinarianError(ignore.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }

        return result;
    }
}
