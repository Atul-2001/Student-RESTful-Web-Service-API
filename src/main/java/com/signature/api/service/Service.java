package com.signature.api.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Service<T, ID> {

    ResponseEntity<T> addEntity(T entity);

    ResponseEntity<T> updateEntity(ID id, T entity);

    T getEntity(ID id);

    List<T> getAllEntities();

    boolean deleteEntity(ID id);

    boolean deleteAllEntities();
}