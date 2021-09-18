package com.signature.api.controller;

import com.signature.api.model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ModelController<T, ID> {

    ResponseEntity<T> add(T entity);

    ResponseEntity<T> update(ID id, T entity);

    List<T> getAll();

    ResponseEntity<T> get(ID id);

    ResponseEntity<Message> deleteAll();

    ResponseEntity<Message> delete(ID id);

}