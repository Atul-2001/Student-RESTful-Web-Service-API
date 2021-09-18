package com.signature.api.repository;

import java.util.Optional;

public interface Repository<T, ID> {

    T save(T entity);

    T update(ID id, T entity);

    Iterable<T> findAll();

    Optional<T> findById(ID id);

    void deleteAll();

    void deleteById(ID id);
}