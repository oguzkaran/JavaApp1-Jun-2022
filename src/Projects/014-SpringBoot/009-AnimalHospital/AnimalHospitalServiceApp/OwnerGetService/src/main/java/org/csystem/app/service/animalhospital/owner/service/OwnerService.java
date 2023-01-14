package org.csystem.app.service.animalhospital.owner.service;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.dal.OwnerServiceHelper;
import com.metemengen.animalhospital.data.entity.OwnerAnimalDetails;
import org.csystem.app.service.animalhospital.owner.dto.OwnersDTO;
import org.csystem.app.service.animalhospital.owner.mapper.IOwnerMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class OwnerService {
    private final OwnerServiceHelper m_ownerServiceHelper;
    private final IOwnerMapper m_ownerMapper;

    public OwnerService(@Qualifier(BeanName.OWNER_SERVICE_HELPER) OwnerServiceHelper ownerServiceHelper,
                        IOwnerMapper ownerMapper)
    {
        m_ownerServiceHelper = ownerServiceHelper;
        m_ownerMapper = ownerMapper;
    }

    public OwnersDTO findOwnersByPhone(String phone)
    {
        return m_ownerMapper.toOwnersDTO(StreamSupport.stream(m_ownerServiceHelper.findOwnerByPhone(phone).spliterator(), false).collect(Collectors.toList()));
    }
}
