package org.csystem.app.service.animalhospital.veterinarian.data.repository;

import org.csystem.app.service.animalhospital.veterinarian.data.entity.Veterinarian;
import org.csystem.util.data.repository.ICrudRepository;

public interface IVeterinarianRepository extends ICrudRepository<Veterinarian, Long> {
    Iterable<Veterinarian> findByLastName(String lastName);
}
