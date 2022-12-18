package com.metemengen.animalhospital.data.repository;


import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.ANIMAL_REPOSITORY)
public class AnimalRepository implements IAnimalRepository {
    private static final String FIND_BY_DIPLOMA_NO = """
            select\s
            a.animal_id as id,\
            a.name as animal_name,\s
            a.type as animal_type,
            a.birth_date as animal_birth_date,
            o.name as owner_name,\s
            o.phone as owner_phone
            from\s
            veterinarians_to_animals va inner join animals a on a.animal_id = va.animal_id\s
            inner join owners o on a.owner_id = o.owner_id\s
            where va.diploma_no = :diplomaNo;
            """;

    private static AnimalOwnerDetails getAnimalOwnerDetails(ResultSet resultSet) throws SQLException
    {
        var id = resultSet.getLong(1);
        var animalName = resultSet.getString(2);
        var animalType = resultSet.getString(3);
        var birthDate = resultSet.getDate(4).toLocalDate();
        var ownerName = resultSet.getString(5);
        var ownerPhone = resultSet.getString(6);

        return new AnimalOwnerDetails(id, animalName, animalType, birthDate, ownerName, ownerPhone);
    }

    private static void fillAnimalDetails(ResultSet resultSet, List<AnimalOwnerDetails> animalOwnerDetails) throws SQLException
    {
        do
            animalOwnerDetails.add(getAnimalOwnerDetails(resultSet));
        while (resultSet.next());
    }

    @Override
    public Iterable<AnimalOwnerDetails> findByDiplomaNo(long diplomaNo)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public long count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(AnimalOwnerDetails entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends AnimalOwnerDetails> entities)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<AnimalOwnerDetails> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<AnimalOwnerDetails> findAllById(Iterable<Long> id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<AnimalOwnerDetails> findById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends AnimalOwnerDetails> S save(S entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends AnimalOwnerDetails> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
