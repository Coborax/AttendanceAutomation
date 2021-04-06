package com.redheads.attendance.DAL;

import com.redheads.attendance.BE.User;

import java.util.List;

public interface IUserDAO {

    List<User> getUsers();

    List<User> getStudents();

    float getUserAbsence(User user);

    void updateAttendance(User user, float newAbsence);

}
