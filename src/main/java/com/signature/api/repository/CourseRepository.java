package com.signature.api.repository;

import com.signature.api.model.Course;
import com.signature.api.resource.CourseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository extends RepositoryImpl<Course, String> {
    public CourseRepository(CourseResourceImpl resource) {
        super(resource);
    }
}