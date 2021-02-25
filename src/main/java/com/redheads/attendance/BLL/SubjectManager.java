package com.redheads.attendance.BLL;

import com.redheads.attendance.BE.Lecture;
import com.redheads.attendance.BE.Subject;
import com.redheads.attendance.BE.User;
import com.redheads.attendance.BE.UserTypeException;
import com.redheads.attendance.DAL.ISubjectDAO;
import com.redheads.attendance.DAL.IUserDAO;
import com.redheads.attendance.DAL.MockSubjectDAO;
import com.redheads.attendance.DAL.MockUserDAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SubjectManager {

    private List<Subject> subjects;
    private ISubjectDAO subjectDAO;

    public SubjectManager() throws UserTypeException {
        subjectDAO = new MockSubjectDAO();
        this.subjects = subjectDAO.getSubjects();
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Lecture> getAllLecturesForUserAtDate(User user, LocalDateTime date) {
        List<Lecture> res = new ArrayList<>();

        for (Subject s : subjects) {
            if (s.getStudents().contains(user)) {
                for (Lecture l : s.getLectures()) {
                    if (checkIfSameDay(l.getStart(), date) && date.isBefore(l.getEnd())) {
                        res.add(l);
                    }
                }
            }
        }

        return res;
    }

    private boolean checkIfSameDay(LocalDateTime a, LocalDateTime b) {
        if (a.getDayOfMonth() == b.getDayOfMonth() &&
                a.getMonth() == b.getMonth() &&
                a.getYear() == b.getYear()) {
            return true;
        }
        return false;
    }

}
