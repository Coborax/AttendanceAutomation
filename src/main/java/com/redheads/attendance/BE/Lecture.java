package com.redheads.attendance.BE;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lecture {
    
    private String name;
    private LocalDate start;
    private LocalDate end;

    private User teacher;
    private List<User> students = new ArrayList<>();

    public Lecture(String name, Date start, Date end, User teacher) throws UserTypeException {
        setName(name);
        setStart(start);
        setEnd(end);
        setTeacher(teacher);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) throws DateTimeException {
        if (start.isBefore(LocalDate.now())) {
            throw new DateTimeException("Date has to be after today or today");
        }
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        if (end.isBefore(LocalDate.now())) {
            throw new DateTimeException("Date has to be after today");
        }
        this.end = end;
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
}
