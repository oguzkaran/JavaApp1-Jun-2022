package com.metemengen.animalhospital.data.mapper;

import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianSave;

public interface IVeterinarianMapper {
    Veterinarian toVeterinarian(VeterinarianSave veterinarianSave);
}
