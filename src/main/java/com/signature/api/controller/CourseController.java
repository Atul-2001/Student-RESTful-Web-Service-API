package com.signature.api.controller;

import com.signature.api.model.Course;
import com.signature.api.model.Level;
import com.signature.api.model.Message;
import com.signature.api.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController implements ModelController<Course, String> {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/course")
    public ResponseEntity<Course> add(@RequestBody Course entity) {
        return service.addEntity(entity);
    }

    @Override
    @PutMapping("/course/{id}")
    public ResponseEntity<Course> update(@PathVariable("id") String id, @RequestBody Course entity) {
        return service.updateEntity(id, entity);
    }

    @Override
    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAll() {
        return service.getAllEntities();
    }

    @Override
    @GetMapping("/course/{id}")
    public ResponseEntity<Course> get(@PathVariable("id") String id) {
        Course course = service.getEntity(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(service.getEntity(id));
        }
    }

    @Override
    @DeleteMapping("/courses")
    public ResponseEntity<Message> deleteAll() {
        if (service.deleteAllEntities()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(new Message(Level.ERROR, "Failed to delete all courses"));
        }
    }

    @Override
    @DeleteMapping("/course/{id}")
    public ResponseEntity<Message> delete(@PathVariable("id") String id) {
        if (service.deleteEntity(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(new Message(Level.ERROR, "Failed to delete course " + id));
        }
    }
}