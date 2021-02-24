package com.redheads.attendance.BE;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lecture {
    
    private String name;
    private Date start;
    private Date end;

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) throws DateTimeException {
        if (start.after(new Date(System.currentTimeMillis()))) {
            throw new DateTimeException("Date has to be after today");
        }
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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
