package com.redheads.attendance.DAL;

import com.redheads.attendance.App;
import com.redheads.attendance.BE.Lecture;
import com.redheads.attendance.BE.Subject;
import com.redheads.attendance.BE.User;
import com.redheads.attendance.BE.UserTypeException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockSubjectDAO implements ISubjectDAO {

    private List<Subject> mockSubjects;

    public MockSubjectDAO() throws UserTypeException {
        mockSubjects = new ArrayList<>();

        // This piece of code is kinda bad, but lets just roll with it as this is only mock data
        // Specifically calling App.userManager is kinda bad... (￢_￢;)
        // Note to self figure out a way to not have userManager public and static... (￢_￢;) (￢_￢;)
        // Also teacher could technically be null, but lets not worry about that (￢_￢;) (￢_￢;) (￢_￢;)
        User teacher = null;
        for (User u : App.userManager.getUsers()) {
            if (u.getType() == User.UserType.TEACHER) {
                teacher = u;
            }
        }

        if (teacher != null) {
            Subject s = new Subject(1, "SCO2", teacher);
            s.addLecture(new Lecture(s, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)));
            s.addStudent(App.userManager.getUsers().get(0));
            s.addStudent(App.userManager.getUsers().get(1));
            mockSubjects.add(s);

            s = new Subject(1, "SDE2", teacher);
            s.addLecture(new Lecture(s, LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)));
            s.addStudent(App.userManager.getUsers().get(0));
            mockSubjects.add(s);
        }

    }

    @Override
    public List<Subject> getSubjects() {
        return List.copyOf(mockSubjects);
    }
}
