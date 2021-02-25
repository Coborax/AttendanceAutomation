package com.redheads.attendance.UI.Models;

import com.redheads.attendance.BE.Subject;
import com.redheads.attendance.BE.User;
import com.redheads.attendance.BLL.SubjectManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AttendanceOverviewModel {

    private SubjectManager subjectManager;

    public AttendanceOverviewModel(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    public ObservableList<Subject> getSubjects(User user) {
        ObservableList<Subject> res = FXCollections.observableArrayList();
        for (Subject s : subjectManager.getSubjects()) {
            res.add(s);
        }
        return res;
    }

    public ObservableList<User> getStudentsInSubject(Subject subject) {
        ObservableList<User> res = FXCollections.observableArrayList();
        for (User u : subject.getStudents()) {
            res.add(u);
        }
        return res;
    }

}
