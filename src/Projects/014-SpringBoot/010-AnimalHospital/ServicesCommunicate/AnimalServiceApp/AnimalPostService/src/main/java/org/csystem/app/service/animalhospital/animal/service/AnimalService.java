package org.csystem.app.service.animalhospital.animal.service;

import com.atahanyengin.animalhospital.data.dal.AnimalPostServiceHelper;
import com.atahanyengin.animalhospital.data.entity.orm.dto.AnimalSaveDTO;
import com.atahanyengin.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final AnimalPostServiceHelper m_animalPostServiceHelper;

    public AnimalService(AnimalPostServiceHelper animalPostServiceHelper)
    {
        m_animalPostServiceHelper = animalPostServiceHelper;
    }

    public AnimalWithOwnerSaveDTO saveAnimalWithOwner(AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        return m_animalPostServiceHelper.saveAnimalWithOwner(animalWithOwnerSaveDTO);
    }
    public AnimalSaveDTO saveAnimal(AnimalSaveDTO animalSaveDTO)
    {
        return m_animalPostServiceHelper.saveAnimal(animalSaveDTO);
    }
}
