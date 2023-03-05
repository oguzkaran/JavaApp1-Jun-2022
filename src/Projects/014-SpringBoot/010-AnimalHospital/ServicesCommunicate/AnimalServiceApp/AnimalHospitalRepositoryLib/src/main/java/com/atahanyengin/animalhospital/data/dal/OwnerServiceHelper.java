package com.atahanyengin.animalhospital.data.dal;

import com.atahanyengin.animalhospital.data.BeanName;
import com.atahanyengin.animalhospital.data.entity.orm.Owner;
import com.atahanyengin.animalhospital.data.repository.orm.IOwnerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.OWNER_SERVICE_HELPER)
@Lazy
public class OwnerServiceHelper {
    private final IOwnerRepository m_ownerRepository;

    public OwnerServiceHelper(IOwnerRepository ownerRepository)
    {
        m_ownerRepository = ownerRepository;
    }

    public Optional<Owner> findOwnerByPhone(String phone)
    {
        return m_ownerRepository.findByPhone(phone);
    }
}
