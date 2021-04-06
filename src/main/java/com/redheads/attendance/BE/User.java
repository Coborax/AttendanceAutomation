package com.redheads.attendance.BE;

public class User {

    public enum UserType { STUDENT, TEACHER }

    private int id;
    private String username;
    private String name;
    private String course;
    private UserType type;
    private float absence = 0.0f;
    private String mostAbsent = "Monday"; //TODO: NO HARDCODE PLZZ

    public User(int id, String username, String name, String course, float absence, UserType type) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.course = course;
        this.absence = absence;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            String otherUsername = (String) ((User) obj).getUsername();
            return otherUsername.equals(this.username);
        }
        return false;
    }

    public float getAbsence() {
        return absence;
    }

    public void setAbsence(float absence) {
        this.absence = absence;
    }

    public String getMostAbsent() {
        return mostAbsent;
    }

    public void setMostAbsent(String mostAbsent) {
        this.mostAbsent = mostAbsent;
    }
}
