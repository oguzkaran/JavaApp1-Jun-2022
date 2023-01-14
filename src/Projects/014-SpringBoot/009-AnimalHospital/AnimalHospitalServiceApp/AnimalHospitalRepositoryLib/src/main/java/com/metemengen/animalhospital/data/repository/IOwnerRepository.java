package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.entity.Owner;
import com.metemengen.animalhospital.data.entity.OwnerAnimalDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IOwnerRepository extends CrudRepository<Owner, Integer> {
    @Query("""
            select new com.metemengen.animalhospital.data.entity.OwnerAnimalDetails(o.name, o.phone, o.address)
            from Owner o where o.phone=:phone
            """)


    Iterable<OwnerAnimalDetails> findByPhone(String phone);
}
