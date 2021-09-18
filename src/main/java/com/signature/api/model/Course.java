package com.signature.api.model;

import java.util.Objects;

public class Course {

    private static int SEQUENCE = 101;

    private String id;
    private String name;
    private String duration;
    private String fees;

    public Course() {
        this.id = "C" + SEQUENCE++;
    }

    public Course(String name, String duration, String fees) {
        this.id = "C" + SEQUENCE++;
        this.name = name;
        this.duration = duration;
        this.fees = fees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course {" +
                "\n\tid : " + id +
                "\n\tname : " + name +
                "\n\tduration : " + duration +
                "\n\tfees : " + fees +
                "\n}";
    }

}