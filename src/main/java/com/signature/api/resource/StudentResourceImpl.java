package com.signature.api.resource;

import com.signature.api.model.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

@Component
public class StudentResourceImpl implements Resource<Student, Integer> {

    private static final Map<Integer, Student> students = new TreeMap<>();

    @Override
    public Student insert(Student entity) {
        if (students.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Key already exist!");
        } else {
            students.put(entity.getId(), entity);
            return students.get(entity.getId());
        }
    }

    @Override
    public Student updateWhereIdEquals(Integer id, Student entity) {
        students.replace(id, entity);
        return students.get(id);
    }

    @Override
    public Student selectAllWhereIdEquals(Integer id) {
        return students.get(id);
    }

    @Override
    public Collection<Student> selectAll() {
        return students.values();
    }

    @Override
    public void delete() {
        students.clear();
    }

    @Override
    public void deleteWhereIdEquals(Integer id) {
        students.remove(id);
    }
}