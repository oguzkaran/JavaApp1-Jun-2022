package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends CrudRepository<Owner, Integer> {

}
