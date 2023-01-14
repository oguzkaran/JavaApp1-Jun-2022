package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.entity.Animal;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IAnimalRepository extends CrudRepository<Animal, Integer> {
    Iterable<Animal> findByNameContainsAndSterile(@Param("text") String text, @Param("sterile") boolean sterile);

    @Query("from Animal a where a.type=:type")
    Iterable<Animal> findByType(@Param("type") String type);

    @Query(nativeQuery = true, value = "select * from animals where date_part('month', birth_date) = :month and date_part('year', birth_date) = :year")
    Iterable<Animal> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}
