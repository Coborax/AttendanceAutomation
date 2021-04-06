package com.redheads.attendance.DAL;

import com.redheads.attendance.BE.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserDAO implements IUserDAO {

    private List<User> mockUsers;

    public MockUserDAO() {
        mockUsers = new ArrayList<>();
        mockUsers.add(new User(0,"kjel0393", "Kjell Schoke", "CSe2020",100.00f, User.UserType.STUDENT));
        mockUsers.add(new User(1,"mikk911a", "Mikkel L. Mouridsen", "CSe2020",3.2f, User.UserType.STUDENT));
        mockUsers.add(new User(2,"jle", "Jeppe Led", "CSe2020",42.00f, User.UserType.TEACHER));
    }

    @Override
    public List<User> getUsers() {
        return List.copyOf(mockUsers);
    }

    @Override
    public List<User> getStudents() {
        return null;
    }


    @Override
    public float getUserAbsence(User user) {
        return 0;
    }

    @Override
    public void updateAttendance(User user, float newAbsence) {

    }

}
