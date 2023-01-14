package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.AnimalOwnerDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.ANIMAL_OWNER_REPOSITORY)
@Lazy
public class AnimalOwnerRepository implements IAnimalOwnerRepository {
    private static final String FIND_BY_DIPLOMA_NO = "select * from find_animal_details_by_diploma(:diplomaNo)";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

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

    public AnimalOwnerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Iterable<AnimalOwnerDetails> findByDiplomaNo(long diplomaNo)
    {
        var paramMap = new HashMap<String, Object>();
        var animalOwnerDetails = new ArrayList<AnimalOwnerDetails>();

        paramMap.put("diplomaNo", diplomaNo);
        m_namedParameterJdbcTemplate.query(FIND_BY_DIPLOMA_NO, paramMap, (ResultSet rs) -> fillAnimalDetails(rs, animalOwnerDetails));

        return animalOwnerDetails;
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
