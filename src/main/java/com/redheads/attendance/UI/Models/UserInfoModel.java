package com.redheads.attendance.UI.Models;

import com.redheads.attendance.BE.User;
import com.redheads.attendance.BLL.UserManager;
import javafx.beans.property.SimpleStringProperty;

public class UserInfoModel {

    private User user;
    private UserManager userManager;

    private SimpleStringProperty userFullName;
    private SimpleStringProperty userCourse;

    public UserInfoModel(UserManager userManager) {
        this.userManager = userManager;

        this.userFullName = new SimpleStringProperty();
        this.userCourse = new SimpleStringProperty();

        setUser(userManager.getUsers().get(1));
    }

    public String getUserFullName() {
        return userFullName.get();
    }

    public SimpleStringProperty userFullNameProperty() {
        return userFullName;
    }

    public String getUserCourse() {
        return userCourse.get();
    }

    public SimpleStringProperty userCourseProperty() {
        return userCourse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        userFullName.set(user.getName());
        userCourse.set(user.getCourse());
    }
}
