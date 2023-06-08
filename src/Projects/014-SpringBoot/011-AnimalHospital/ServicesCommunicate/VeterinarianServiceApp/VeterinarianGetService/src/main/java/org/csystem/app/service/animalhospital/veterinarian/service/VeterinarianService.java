package org.csystem.app.service.animalhospital.veterinarian.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.VeterinarianServiceHelper;
import org.csystem.app.service.animalhospital.veterinarian.dto.*;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianWithFullNameMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.Optional;
import static org.csystem.util.collection.CollectionUtil.*;

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
        return doForDataService(() -> m_veterinarianMapper.toCountDTO(m_veterinarianServiceHelper.countVeterinarians()),
                "VeterinarianService.countVeterinarians");
    }

    public VeterinarianExistsDTO existsVeterinarianByDiplomaNo(Long diplomaNo)
    {
        return new VeterinarianExistsDTO(m_veterinarianServiceHelper.existsVeterinarianByDiplomaNo(diplomaNo));
    }

    public VeterinariansDTO findAllVeterinarians()
    {
        var veterinarians = m_veterinarianMapper.toVeterinariansDTO(
                toList(m_veterinarianServiceHelper.findAllVeterinarians(), m_veterinarianMapper::toVeterinarianDTO));

        return doForDataService(() -> veterinarians, "VeterinarianService.findAllVeterinarians");
    }

    public Optional<VeterinarianDTO> findVeterinarianByDiplomaNo(long diplomaNo)
    {
        return doForDataService(() -> m_veterinarianServiceHelper.findVeterinarianById(diplomaNo)
                .map(m_veterinarianMapper::toVeterinarianDTO), "VeterinarianService.findVeterinarianByDiplomaNo");
    }

    public VeterinariansDTO findVeterinariansByLastName(String lastName)
    {
        return doForDataService(() -> m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(
                m_veterinarianServiceHelper.findVeterinariansByLastName(lastName), m_veterinarianMapper::toVeterinarianDTO)),
                "VeterinarianService.findVeterinariansByLastName");
    }

    public VeterinariansDTO findVeterinariansByMonthAndYear(int month, int year)
    {
        return doForDataService(() -> m_veterinarianMapper.toVeterinariansDTO(CollectionUtil.toList(
                m_veterinarianServiceHelper.findVeterinariansByMonthAndYear(month, year), m_veterinarianMapper::toVeterinarianDTO)),
                "VeterinarianService.findVeterinariansByMonthAndYear");
    }

    public VeterinariansWithFullNameDTO findVeterinariansByYearBetween(int begin, int end)
    {
        return doForDataService(() -> m_veterinarianWithFullNameMapper.toVeterinariansDTO(
                        CollectionUtil.toList(m_veterinarianServiceHelper.findVeterinariansByYearBetween(begin, end), m_veterinarianWithFullNameMapper::toVeterinarianWithFullName)),
                "VeterinarianService.findVeterinariansByYearBetween");
    }

    public VeterinariansWithFullNameDTO findAllVeterinariansWithFullName()
    {
        return doForDataService(() -> m_veterinarianWithFullNameMapper.toVeterinariansDTO(
                        CollectionUtil.toList(m_veterinarianServiceHelper.findAllVeterinariansWithFullName(), m_veterinarianWithFullNameMapper::toVeterinarianWithFullName)),
                "VeterinarianService.findAllVeterinariansWithFullName");
    }
    //...
}
