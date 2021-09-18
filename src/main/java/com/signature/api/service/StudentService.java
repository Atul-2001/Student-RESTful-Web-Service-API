package com.signature.api.service;

import com.signature.api.model.Student;
import com.signature.api.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService extends ServiceImpl<Student, Integer> {

    public StudentService(StudentRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Student> updateEntity(Integer id, Student entity) {
        if (id != null || entity != null) {
            if (entity.getId().equals(id)) {
                Optional<Student> student = super.repository.findById(id);
                if (student.isPresent()) {
                    if (student.get().getId().equals(entity.getId())) {
                        if (super.repository.update(id, entity).equals(entity)) {
                            return ResponseEntity.ok(entity);
                        }
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }
}