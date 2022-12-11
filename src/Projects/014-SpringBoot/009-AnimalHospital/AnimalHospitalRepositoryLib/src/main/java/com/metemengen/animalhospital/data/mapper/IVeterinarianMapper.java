package com.metemengen.animalhospital.data.mapper;

import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianSave;

public interface IVeterinarianMapper {
    VeterinarianSave toVeterinarianSave(Veterinarian veterinarian);
    Veterinarian toVeterinarian(VeterinarianSave veterinarianSave);
}
