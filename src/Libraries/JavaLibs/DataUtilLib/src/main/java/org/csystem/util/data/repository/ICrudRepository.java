/*----------------------------------------------------------------------
	FILE        : ICrudRepository.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 27.11.2022

	Abstraction of general CRUD operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.data.repository;

import java.util.Optional;

public interface ICrudRepository<T, Id> {
    long count();
    void delete(T entity);
    void deleteAll();
    void deleteAll(Iterable<? extends T> entities);
    void deleteAllById(Iterable<? extends Id> ids);
    void deleteById(Id id);
    boolean existsById(Id id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<Id> id);
    Optional<T> findById(Id id);
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
}
