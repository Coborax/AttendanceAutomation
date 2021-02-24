package com.redheads.attendance.DAL;

import com.redheads.attendance.BE.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserDAO implements IUserDAO {

    private List<User> mockUsers;

    public MockUserDAO() {
        mockUsers = new ArrayList<>();
        mockUsers.add(new User("kjel0393", "Kjell Schoke", "CSe2020", User.UserType.STUDENT));
        mockUsers.add(new User("mikk911a", "Mikkel L. Mouridsen", "CSe2020", User.UserType.STUDENT));
        mockUsers.add(new User("jle", "Jeppe Led", "CSe2020", User.UserType.TEACHER));
    }

    @Override
    public List<User> getUsers() {
        return List.copyOf(mockUsers);
    }
}
