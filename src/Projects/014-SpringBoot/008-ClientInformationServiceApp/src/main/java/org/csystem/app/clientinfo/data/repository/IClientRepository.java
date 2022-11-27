package org.csystem.app.clientinfo.data.repository;

import org.csystem.app.clientinfo.data.entity.Client;
import org.csystem.util.data.repository.ICrudRepository;

public interface IClientRepository extends ICrudRepository<Client, Long> {
    Iterable<Client> findByHost(String host);
    Iterable<Client> findByDateTimeMonthBetween(int first, int last);
    //...
}
