package com.redheads.attendance.BLL;

import com.redheads.attendance.BE.User;
import com.redheads.attendance.DAL.IUserDAO;
import com.redheads.attendance.DAL.MockUserDAO;

import java.util.List;

public class UserManager {

    private List<User> users;

    private IUserDAO userDAO;

    public UserManager() {
        userDAO = new MockUserDAO();
        this.users = userDAO.getUsers();
    }

    public List<User> getUsers() {
        return users;
    }
}
