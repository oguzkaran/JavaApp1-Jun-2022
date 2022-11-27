package org.csystem.app.clientinfo.data.repository;

import org.csystem.app.clientinfo.data.entity.Client;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientRepository implements IClientRepository {

    //Implemented methods
    @Override
    public long count()
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    //Not implemented methods
    @Override
    public Iterable<Client> findByHost(String host)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Iterable<Client> findByDateTimeMonthBetween(int first, int last)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }



    @Override
    public void delete(Client entity)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void deleteAll(Iterable<? extends Client> entities)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean existsById(Long aLong)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Iterable<Client> findAll()
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Iterable<Client> findAllById(Iterable<Long> id)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Optional<Client> findById(Long aLong)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public <S extends Client> S save(S entity)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public <S extends Client> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
