package com.signature.api.service;

import com.signature.api.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class ServiceImpl<T, ID> implements Service<T, ID> {

    protected final Repository<T, ID> repository;

    public ServiceImpl(Repository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<T> addEntity(T entity) {
        if (entity != null) {
            try {
                if (repository.save(entity).equals(entity)) {
                    return ResponseEntity.ok(entity);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @Override
    public abstract ResponseEntity<T> updateEntity(ID id, T entity);

    @Override
    public T getEntity(ID id) {
        if (id != null) {
            return repository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public List<T> getAllEntities() {
        Iterable<T> students = repository.findAll();
        return StreamSupport.stream(students.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEntity(ID id) {
        if (id != null) {
            repository.deleteById(id);
            Optional<T> student = repository.findById(id);
            return student.isEmpty();
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean deleteAllEntities() {
        repository.deleteAll();
        return !repository.findAll().iterator().hasNext();
    }
}