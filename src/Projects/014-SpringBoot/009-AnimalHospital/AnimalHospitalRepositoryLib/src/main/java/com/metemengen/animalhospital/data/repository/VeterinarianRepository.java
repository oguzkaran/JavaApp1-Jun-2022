package com.metemengen.animalhospital.data.repository;

import com.metemengen.animalhospital.data.BeanName;
import com.metemengen.animalhospital.data.entity.Veterinarian;
import com.metemengen.animalhospital.data.entity.VeterinarianWithoutCitizenId;
import com.metemengen.animalhospital.data.mapper.IVeterinarianMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.VETERINARIAN_REPOSITORY)
public class VeterinarianRepository implements IVeterinarianRepository {
    private static final String COUNT_SQL = "select count(*) from veterinarians";
    private static final String FIND_BY_DIPLOMA_NO_SQL = "select * from veterinarians where diploma_no=:diplomaNo";
    private static final String FIND_BY_LAST_NAME_SQL = "select * from veterinarians where last_name=:lastName";

    private static final String FIND_BY_MONTH_AND_YEAR_SQL = """
            select * from veterinarians where date_part('month', register_date) = :month\s
            and date_part('year', register_date) = :year""";

    private static final String FIND_BY_YEAR_BETWEEN_SQL = """
            select diploma_no, first_name, middle_name, last_name, birth_date, register_date\s
            from veterinarians where date_part('year', register_date) between :begin and :end
            """;
    private static final String FIND_BY_MONTH_SQL = """
                select diploma_no, first_name, middle_name, last_name, birth_date, register_date\s
                from veterinarians where date_part('month', register_date) = :month
                """;
    private static final String FIND_BY_YEAR_SQL = "select * from veterinarians where date_part('year', register_date) = :year";

    private static final String SAVE_SQL = """
            insert into veterinarians (diploma_no, citizen_id, first_name, middle_name, last_name, birth_date, register_date)
            values (:diplomaNo, :citizenId, :firstName, :middleName, :lastName, :birthDate, :registerDate)""";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    private final IVeterinarianMapper m_veterinarianMapper;

    private static Veterinarian getVeterinarian(ResultSet rs) throws SQLException
    {
        var diplomaNo = rs.getLong(1);
        var citizenId = rs.getString(2);
        var firstName = rs.getString(3);
        var middleNameOpt = Optional.ofNullable(rs.getString(4));
        var lastName = rs.getString(5);
        var birthDate = rs.getDate(6).toLocalDate();
        var registerDate = rs.getDate(7).toLocalDate();

        return new Veterinarian(diplomaNo, citizenId, firstName, middleNameOpt, lastName, birthDate, registerDate);
    }

    private static VeterinarianWithoutCitizenId getVeterinarianWithoutCitizenId(ResultSet rs) throws SQLException
    {
        var diplomaNo = rs.getLong("diploma_no");
        var firstName = rs.getString("first_name");
        var middleNameOpt = Optional.ofNullable(rs.getString("middle_name"));
        var lastName = rs.getString("last_name");
        var birthDate = rs.getDate("birth_date").toLocalDate();
        var registerDate = rs.getDate("register_date").toLocalDate();

        return new VeterinarianWithoutCitizenId(diplomaNo, firstName, middleNameOpt, lastName, birthDate, registerDate);
    }

    private static void fillVeterinarians(ResultSet rs, List<Veterinarian> veterinarians) throws SQLException
    {
        do
            veterinarians.add(getVeterinarian(rs));
        while (rs.next());
    }

    private static void fillVeterinariansWithoutCitizenId(ResultSet rs, List<VeterinarianWithoutCitizenId> veterinarians) throws SQLException
    {
        do
            veterinarians.add(getVeterinarianWithoutCitizenId(rs));
        while (rs.next());
    }

    public VeterinarianRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                                  @Qualifier(BeanName.VETERINARIAN_MAPPER) IVeterinarianMapper veterinarianMapper)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        m_veterinarianMapper = veterinarianMapper;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {counts.add(rs.getLong(1));});

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

    @Override
    public Iterable<Veterinarian> findByMonthAndYear(int month, int year)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<Veterinarian>();

        paramMap.put("month", month);
        paramMap.put("year", year);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH_AND_YEAR_SQL, paramMap, (ResultSet rs) -> fillVeterinarians(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<VeterinarianWithoutCitizenId> findByYearBetween(int begin, int end)
    {
        var paramMap = new HashMap<String, Object>();
        var veterinarians = new ArrayList<VeterinarianWithoutCitizenId>();

        paramMap.put("begin", begin);
        paramMap.put("end", end);

        m_namedParameterJdbcTemplate.query(FIND_BY_YEAR_BETWEEN_SQL, paramMap, (ResultSet rs) -> fillVeterinariansWithoutCitizenId(rs, veterinarians));

        return veterinarians;
    }

    @Override
    public Iterable<Veterinarian> findByMonth(int month)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Iterable<Veterinarian> findByYear(int year)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }


    @Override
    public <S extends Veterinarian> S save(S veterinarian)
    {
        var paramSource = new BeanPropertySqlParameterSource(m_veterinarianMapper.toVeterinarianSave(veterinarian));

        paramSource.registerSqlType("birthDate", Types.DATE);
        paramSource.registerSqlType("registerDate", Types.DATE);
        m_namedParameterJdbcTemplate.update(SAVE_SQL, paramSource);

        return veterinarian;
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
    public <S extends Veterinarian> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
