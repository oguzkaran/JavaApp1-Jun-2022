package com.metemengen.animalhospital.data.repository.orm;

import com.metemengen.animalhospital.data.entity.orm.Owner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IOwnerRepository extends CrudRepository<Owner, Integer> {
    Iterable<Owner> findByPhone(String phone);
}
