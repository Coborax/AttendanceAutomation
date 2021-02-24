package com.redheads.attendance.BE;

public class User {

    public enum UserType { STUDENT, TEACHER }

    private String username;
    private String name;
    private UserType type;

    public User(String username, String name, UserType type) {
        this.username = username;
        this.name = name;
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
}
