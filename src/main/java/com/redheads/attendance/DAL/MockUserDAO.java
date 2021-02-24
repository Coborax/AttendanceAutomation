package com.redheads.attendance.DAL;

import com.redheads.attendance.BE.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserDAO implements UserDAO {

    private List<User> mockUsers;

    public MockUserDAO() {
        mockUsers = new ArrayList<>();
        mockUsers.add(new User("kjel0393", "Kjell Schoke", User.UserType.STUDENT));
        mockUsers.add(new User("mikk911a", "Mikkel L. Mouridsen", User.UserType.STUDENT));
        mockUsers.add(new User("jle", "Jeppe Led", User.UserType.TEACHER));
    }

    @Override
    public List<User> getUsers() {
        return List.copyOf(mockUsers);
    }
}
