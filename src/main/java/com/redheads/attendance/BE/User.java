package com.redheads.attendance.BE;

public class User {

    public enum UserType { STUDENT, TEACHER }

    private String username;
    private String name;
    private String course;
    private UserType type;

    public User(String username, String name, String course, UserType type) {
        this.username = username;
        this.name = name;
        this.course = course;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
