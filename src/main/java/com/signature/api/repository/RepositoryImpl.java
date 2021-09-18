package com.signature.api.repository;

import com.signature.api.resource.Resource;

import java.util.Optional;

public abstract class RepositoryImpl<T, ID> implements Repository<T, ID> {

    private final Resource<T, ID> resource;

    public RepositoryImpl(Resource<T, ID> resource) {
        this.resource = resource;
    }

    @Override
    public T save(T entity) {
        return resource.insert(entity);
    }

    @Override
    public T update(ID id, T entity) {
        return resource.updateWhereIdEquals(id, entity);
    }

    @Override
    public Iterable<T> findAll() {
        return resource.selectAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(resource.selectAllWhereIdEquals(id));
    }

    @Override
    public void deleteAll() {
        resource.delete();
    }

    @Override
    public void deleteById(ID id) {
        resource.deleteWhereIdEquals(id);
    }
}