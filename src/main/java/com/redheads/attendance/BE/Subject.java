package com.redheads.attendance.BE;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private int id;
    private String name;
    private User teacher;
    private List<User> students = new ArrayList<>();
    private List<Lecture> lectures = new ArrayList<>();

    public Subject(int id, String name, User teacher) throws UserTypeException {
        this.id = id;
        setName(name);
        setTeacher(teacher);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Subject) {
            Integer otherID = (Integer)((Subject) obj).id;
            return otherID.equals(this.id);
        }
        return false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) throws UserTypeException {
        if (teacher.getType() != User.UserType.TEACHER) {
            throw new UserTypeException("User should be a teacher");
        }
        this.teacher = teacher;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public List<User> getStudents() {
        return students;
    }

    public void addStudent(User student) {
        students.add(student);
    }

}
