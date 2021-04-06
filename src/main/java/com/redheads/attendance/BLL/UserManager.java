package com.redheads.attendance.BLL;

import com.redheads.attendance.BE.User;
import com.redheads.attendance.DAL.IUserDAO;
import com.redheads.attendance.DAL.MockUserDAO;

import java.util.List;

public class UserManager {

    private List<User> users;
    private IUserDAO userDAO;

    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private UserManager() {
        userDAO = new MockUserDAO();
        this.users = userDAO.getUsers();
    }

    public void updateAllUsersAttendance() {
        for (User u : users) {
            updateUserAttendance(u);
        }
    }

    private void updateUserAttendance(User user) {
        user.setAbsence(SubjectManager.getInstance().getAttendancePercent(user));
    }

    public List<User> getUsers() {
        return users;
    }
}
