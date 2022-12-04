package org.csystem.app.service.animalhospital.data.repository;

import org.csystem.app.service.animalhospital.data.entity.Owner;
import org.csystem.util.data.repository.ICrudRepository;

public interface IOwnerRepository extends ICrudRepository<Owner, Integer> {
    Iterable<Owner> findByPhone(String phone);
}
