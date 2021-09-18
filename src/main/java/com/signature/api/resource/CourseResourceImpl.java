package com.signature.api.resource;

import com.signature.api.model.Course;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

@Component
public class CourseResourceImpl implements Resource<Course, String> {

    private static final Map<String, Course> courses = new TreeMap<>();

    @Override
    public Course insert(Course entity) {
        if (courses.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Key already exist!");
        } else {
            courses.put(entity.getId(), entity);
            return courses.get(entity.getId());
        }
    }

    @Override
    public Course updateWhereIdEquals(String id, Course entity) {
        courses.replace(id, entity);
        return courses.get(id);
    }

    @Override
    public Course selectAllWhereIdEquals(String id) {
        return courses.get(id);
    }

    @Override
    public Collection<Course> selectAll() {
        return courses.values();
    }

    @Override
    public void delete() {
        courses.clear();
    }

    @Override
    public void deleteWhereIdEquals(String id) {
        courses.remove(id);
    }
}