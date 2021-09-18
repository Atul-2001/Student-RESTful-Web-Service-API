package com.signature.api.model;

import java.util.Objects;

public class Student {

    private static int SEQUENCE = 1;

    private Integer id;
    private String name;
    private String dob;
    private String email;
    private String mobile;
    private Course course;

    public Student() {
        this.id = SEQUENCE++;
    }

    public Student(String name, String dob, String email, String mobile, Course course) {
        this.id = SEQUENCE++;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.mobile = mobile;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student {" +
                "\n\tid : " + id +
                "\n\tname : " + name +
                "\n\tdob : " + dob +
                "\n\temail : " + email +
                "\n\tmobile : " + mobile +
                "\n\tcourse : " + course.toString() +
                "\n}";
    }

}