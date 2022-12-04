package org.csystem.app.service.animalhospital.data.repository;

import org.csystem.app.service.animalhospital.data.entity.Owner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Optional;

public class OwnerRepository implements IOwnerRepository {
    private static final String COUNT_SQL = "select count(*) from owners";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public OwnerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Iterable<Owner> findByPhone(String phone)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Owner entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Owner> entities)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Integer integer)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Integer integer)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Owner> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Owner> findAllById(Iterable<Integer> id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Owner> findById(Integer integer)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Owner> S save(S entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Owner> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
