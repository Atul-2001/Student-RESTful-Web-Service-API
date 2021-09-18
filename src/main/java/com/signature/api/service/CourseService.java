package com.signature.api.service;

import com.signature.api.model.Course;
import com.signature.api.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService extends ServiceImpl<Course, String> {

    public CourseService(Repository<Course, String> repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Course> updateEntity(String id, Course entity) {
        if (id != null || entity != null) {
            if (entity.getId().equals(id)) {
                Optional<Course> course = super.repository.findById(id);
                if (course.isPresent()) {
                    if (course.get().getId().equals(entity.getId())) {
                        if (repository.update(id, entity).equals(entity)) {
                            return ResponseEntity.ok(entity);
                        }
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}