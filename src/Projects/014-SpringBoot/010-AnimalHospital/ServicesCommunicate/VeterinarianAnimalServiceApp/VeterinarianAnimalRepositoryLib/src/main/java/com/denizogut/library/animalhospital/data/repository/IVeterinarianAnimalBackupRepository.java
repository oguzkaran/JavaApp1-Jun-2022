package com.denizogut.library.animalhospital.data.repository;

import com.denizogut.library.animalhospital.data.entity.backup.VeterinarianAnimalBackup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface IVeterinarianAnimalBackupRepository extends CrudRepository<VeterinarianAnimalBackup, UUID> {

}
