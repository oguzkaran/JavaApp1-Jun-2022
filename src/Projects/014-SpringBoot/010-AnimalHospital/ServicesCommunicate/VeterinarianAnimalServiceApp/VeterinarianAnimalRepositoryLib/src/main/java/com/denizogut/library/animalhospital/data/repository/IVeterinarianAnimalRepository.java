package com.denizogut.library.animalhospital.data.repository;

import com.denizogut.library.animalhospital.data.entity.VeterinarianAnimal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVeterinarianAnimalRepository extends CrudRepository<VeterinarianAnimal, Long> {
}
