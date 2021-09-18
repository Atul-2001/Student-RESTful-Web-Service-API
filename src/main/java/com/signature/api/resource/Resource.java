package com.signature.api.resource;

import java.util.Collection;

public interface Resource<T, ID> {

    T insert(T entity);

    T updateWhereIdEquals(ID id, T entity);

    T selectAllWhereIdEquals(ID id);

    Collection<T> selectAll();

    void delete();

    void deleteWhereIdEquals(ID id);
}