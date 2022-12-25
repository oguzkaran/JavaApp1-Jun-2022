package org.csystem.app.service.animalhospital.animal.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.AnimalServiceHelper;
import org.csystem.app.service.animalhospital.animal.dto.AnimalsOwnerDetailsDTO;
import org.csystem.app.service.animalhospital.animal.mapper.IAnimalOwnerDetailsMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import static org.csystem.util.collection.CollectionUtil.toList;
@Service
public class AnimalAppService {
    private final AnimalServiceHelper m_animalServiceHelper;
    private final IAnimalOwnerDetailsMapper m_animalOwnerDetailsMapper;

    public AnimalAppService(@Qualifier(BeanName.ANIMAL_SERVICE_HELPER) AnimalServiceHelper animalServiceHelper,
                            IAnimalOwnerDetailsMapper animalOwnerDetailsMapper)
    {
        m_animalServiceHelper = animalServiceHelper;
        m_animalOwnerDetailsMapper = animalOwnerDetailsMapper;
    }

    public AnimalsOwnerDetailsDTO findByAnimalsOwnersByDiplomaNo(@RequestParam("no") long diplomaNo)
    {
        return m_animalOwnerDetailsMapper.toAnimalsOwnerDetailsDTO(toList(m_animalServiceHelper.findAnimalOwnerDetailsByDiplomaNo(diplomaNo),
                m_animalOwnerDetailsMapper::toAnimalOwnerDetailsDTO));
    }
}
