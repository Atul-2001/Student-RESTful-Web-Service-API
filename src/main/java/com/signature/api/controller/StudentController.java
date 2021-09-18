package com.signature.api.controller;

import com.signature.api.model.Level;
import com.signature.api.model.Message;
import com.signature.api.model.Student;
import com.signature.api.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController implements ModelController<Student, Integer> {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/student")
    public ResponseEntity<Student> add(@RequestBody Student entity) {
        return service.addEntity(entity);
    }

    @Override
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Integer id, @RequestBody Student entity) {
        return service.updateEntity(id, entity);
    }

    @Override
    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAll() {
        return service.getAllEntities();
    }

    @Override
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") Integer id) {
        Student student = service.getEntity(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(service.getEntity(id));
        }
    }

    @Override
    @DeleteMapping("/students")
    public ResponseEntity<Message> deleteAll() {
        if (service.deleteAllEntities()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(new Message(Level.ERROR, "Failed to delete all students"));
        }
    }

    @Override
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Message> delete(@PathVariable("id") Integer id) {
        if (service.deleteEntity(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(new Message(Level.ERROR, "Failed to delete student " + id));
        }
    }
}