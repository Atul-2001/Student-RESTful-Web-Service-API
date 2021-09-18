package com.signature.api.repository;

import com.signature.api.model.Student;
import com.signature.api.resource.StudentResourceImpl;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository extends RepositoryImpl<Student, Integer> {
    public StudentRepository(StudentResourceImpl resource) {
        super(resource);
    }
}