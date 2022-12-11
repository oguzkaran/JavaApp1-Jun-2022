package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.VETERINARIAN_REPOSITORY)
public class VeterinarianRepository implements IVeterinarianRepository {
    private static final String COUNT_SQL = "select count(*) from veterinarians";
    private static final String FIND_BY_DIPLOMA_NO_SQL = "select * from veterinarians where diploma_no=:diplomaNo";
    private static final String FIND_BY_LAST_NAME_SQL = "select * from veterinarians where last_name=:lastName";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private static Veterinarian getVeterinarian(ResultSet rs) throws SQLException
    {
        var diplomaNo = rs.getLong(1);
        var citizenId = rs.getString(2);
        var firstName = rs.getString("first_name");
        var middleNameOpt = Optional.ofNullable(rs.getString(4));
        var lastName = rs.getString(5);
        var birthDate = rs.getDate(6).toLocalDate();
        var registerDate = rs.getDate(7).toLocalDate();

        return new Veterinarian(diplomaNo, citizenId, firstName, middleNameOpt, lastName, birthDate, registerDate);
    }

    private static void fillVeterinarians(ResultSet rs, List<Veterinarian> veterinarians) throws SQLException
    {
        do
            veterinarians.add(getVeterinarian(rs));
        while (rs.next());
    }

    public VeterinarianRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL,  rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }

    @Override
    public Optional<Veterinarian> findById(Long diplomaNo)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("diplomaNo", diplomaNo);

        m_namedParameterJdbcTemplate.query(FIND_BY_DIPLOMA_NO_SQL, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians.isEmpty() ? Optional.empty() : Optional.of(veterinarians.get(0));
    }

    @Override
    public Iterable<Veterinarian> findByLastName(String lastName)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("lastName", lastName);

        m_namedParameterJdbcTemplate.query(FIND_BY_LAST_NAME_SQL, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians;
    }

    ////////////////////////////////////////////////////////////////////


    @Override
    public void delete(Veterinarian entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Veterinarian> entities)
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
    public Iterable<Veterinarian> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Veterinarian> findAllById(Iterable<Long> id)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public <S extends Veterinarian> S save(S entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Veterinarian> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
