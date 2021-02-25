package com.redheads.attendance.UI.Models;

import com.redheads.attendance.BE.Lecture;
import com.redheads.attendance.BE.User;
import com.redheads.attendance.BLL.SubjectManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class AttendanceModel {

    private SubjectManager subjectManager;

    private LocalDateTime date = LocalDateTime.now();

    public AttendanceModel(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    public boolean validateAttendance(User user, Lecture lecture, boolean wasThere) {
        date = LocalDateTime.now();
        if (user.getType() != User.UserType.TEACHER) {
            if (lecture.getStart().isBefore(date) && lecture.getEnd().isAfter(date)) {
                updateAttendance(user, lecture, wasThere);
                return true;
            }
        } else {
            updateAttendance(user, lecture, wasThere);
            return true;
        }
        return false;
    }

    private void updateAttendance(User user, Lecture lecture, boolean wasThere) {
        if (wasThere) {
            lecture.addPresent(user);
        } else {
            lecture.removePresent(user);
        }
    }

    public ObservableList<Lecture> getLecturesForUser(User user) {
        return FXCollections.observableArrayList(subjectManager.getAllLecturesForUserAtDate(user, date));
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
