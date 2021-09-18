package com.signature.api.controller;

import com.signature.api.model.Course;
import com.signature.api.model.Student;
import com.signature.api.resource.CourseResourceImpl;
import com.signature.api.resource.Resource;
import com.signature.api.resource.StudentResourceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FakeDataController {

    private final Resource<Course, String> courseResource;
    private final Resource<Student, Integer> studentResource;

    public FakeDataController(CourseResourceImpl courseResource, StudentResourceImpl studentResource) {
        this.courseResource = courseResource;
        this.studentResource = studentResource;
    }

    @GetMapping("/fake/data")
    public List<Student> addFakeData() {
        courseResource.delete();
        studentResource.delete();

        final Course BCA = new Course("Bachelor of Computer Application (BCA)", "3 year(6 semester)", "57,000/- year");
        final Course BBA = new Course("Bachelor of Business Administration (BBA)", "3 year(6 semester)", "54000/- year");
        final Course BTech = new Course("Bachelor of Technology (B.Tech)", "4 year(8 semester)", "150000/- year");

        courseResource.insert(BCA);
        courseResource.insert(BBA);
        courseResource.insert(BTech);

        Student s1 = new Student("Tushendra Suryavanshi", "27/08/1998", "tushendrasuryvanshi27@gmail.com", "7054935280", BTech);
        Student s2 = new Student("Atendra Suryavanshi", "15/09/2001", "atul.atendra15@gmail.com", "8869975446", BCA);
        Student s3 = new Student("Nikhil Singh", "20/10/2000", "nikhilsingh20@gmail.com", "9756302854", BBA);

        studentResource.insert(s1);
        studentResource.insert(s2);
        studentResource.insert(s3);

        return new ArrayList<>(studentResource.selectAll());
    }
}