package com.metemengen.animalhospital.data.repository.orm;

import com.metemengen.animalhospital.data.entity.orm.Animal;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalOwnerDetails;
import com.metemengen.animalhospital.data.entity.orm.view.IAnimalWithoutOwner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IAnimalRepository extends CrudRepository<Animal, Integer> {
    Iterable<Animal> findByNameContainsAndSterile(@Param("text") String text, @Param("sterile") boolean sterile);

    Iterable<IAnimalWithoutOwner> findByType(@Param("type") String type);

    @Query(nativeQuery = true, value = "select * from animals where date_part('month', birth_date) = :month and date_part('year', birth_date) = :year")
    Iterable<Animal> findByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query("""
        select new com.metemengen.animalhospital.data.entity.orm.dto.AnimalOwnerDetails(a.name, a.type, a.birthDate, o.name, o.phone)\s
        from Animal a inner join Owner o on o = a.owner where a.name = ?1\s
        """)
    Iterable<AnimalOwnerDetails> findByName(@Param("name") String name);
}
