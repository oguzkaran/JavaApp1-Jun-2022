package com.atahanyengin.animalhospital.data.repository.orm;

import com.atahanyengin.animalhospital.data.entity.orm.Owner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
public interface IOwnerRepository extends CrudRepository<Owner, Integer> {
    Optional<Owner> findByPhone(String phone);
}
