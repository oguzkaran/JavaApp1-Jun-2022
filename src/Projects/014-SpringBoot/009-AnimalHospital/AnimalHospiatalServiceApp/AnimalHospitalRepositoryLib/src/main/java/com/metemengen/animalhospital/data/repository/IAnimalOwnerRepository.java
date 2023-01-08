package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import org.csystem.util.data.repository.ICrudRepository;

public interface IAnimalOwnerRepository extends ICrudRepository<AnimalOwnerDetails, Long> {
    Iterable<AnimalOwnerDetails> findByDiplomaNo(long diplomaNo);
}
