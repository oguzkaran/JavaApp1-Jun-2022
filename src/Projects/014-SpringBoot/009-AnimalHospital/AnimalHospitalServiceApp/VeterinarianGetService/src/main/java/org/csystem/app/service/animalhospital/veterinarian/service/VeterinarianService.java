package org.csystem.app.service.animalhospital.veterinarian.service;

import com.karandev.util.data.repository.exception.RepositoryException;
import com.karandev.util.data.service.DataServiceException;
import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;
import org.csystem.app.service.animalhospital.veterinarian.dto.CountDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinarianDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansDTO;
import org.csystem.app.service.animalhospital.veterinarian.dto.VeterinariansWithFullNameDTO;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithFullNameMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.karandev.util.data.error.DataUtil.doForDataService;

@Service
public class VeterinarianService {
    private final VeterinarianServiceHelper m_veterinarianServiceHelper;
    private final IVeterinarianMapper m_veterinarianMapper;

    private final IVeterinarianWithFullNameMapper m_veterinarianWithFullNameMapper;

    public VeterinarianService(@Qualifier(BeanName.VETERINARIAN_SERVICE_HELPER) VeterinarianServiceHelper veterinarianServiceHelper,
                               IVeterinarianMapper veterinarianMapper,
                               IVeterinarianWithFullNameMapper veterinarianWithFullNameMapper)
    {
        m_veterinarianServiceHelper = veterinarianServiceHelper;
        m_veterinarianMapper = veterinarianMapper;
        m_veterinarianWithFullNameMapper = veterinarianWithFullNameMapper;
    }

    public CountDTO countVeterinarians()
    {
        return doForDataService(() -> m_veterinarianMapper.toCountDTO(m_veterinarianServiceHelper.countVeterinarians()), "VeterinarianService.countVeterinarians");
    }
    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return doForDataService(() ->m_veterinarianServiceHelper.findVeterinarianById(diplomaNo).map(m_veterinarianMapper::toVeterinarianDTO), "VeterinarianService.findVeterinarianByDiplomaNo");
    }

    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        try {
            return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByLastName(lastName), m_veterinarianMapper::toVeterinarianDTO));
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("VeterinarianService.findVeterinariansByLastName", ex.getCause());
        }
    }
    public VeterinariansDTO findVeterinariansByMonthAndYear(int month, int year)
    {
        try {
            return m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByMonthAndYear(month, year), m_veterinarianMapper::toVeterinarianDTO));
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("VeterinarianService.findVeterinariansByMonthAndYear", ex.getCause());
        }
    }

    public VeterinariansWithFullNameDTO findVeterinariansByYearBetween(int begin, int end)
    {
        try {
            return m_veterinarianWithFullNameMapper.toVeterinariansDTO(
                    CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByYearBetween(begin, end), m_veterinarianWithFullNameMapper::toVeterinarianWithFullName) );
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("VeterinarianService.findVeterinariansByYearBetween", ex.getCause());
        }
    }
    //...
}
