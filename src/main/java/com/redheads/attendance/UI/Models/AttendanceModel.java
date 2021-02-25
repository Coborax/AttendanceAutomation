package com.redheads.attendance.UI.Models;

import com.redheads.attendance.BE.Lecture;
import com.redheads.attendance.BE.User;
import com.redheads.attendance.BLL.SubjectManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class AttendanceModel {

    private SubjectManager subjectManager;

    private LocalDateTime date = LocalDateTime.now();

    public AttendanceModel(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    public ObservableList<Lecture> getLecturesForUser(User user) {
        return FXCollections.observableArrayList(subjectManager.getAllLecturesforUserAtDate(user, date));
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
