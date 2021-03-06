package com.redheads.attendance.BE;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Lecture {

    private Subject subject;
    private LocalDateTime start;
    private LocalDateTime end;

    private List<User> presentList = new ArrayList<>();

    public Lecture(Subject subject, LocalDateTime start, LocalDateTime end) throws UserTypeException {
        setSubject(subject);

        // Set directly to bypass validation
        this.start = start;
        this.end = end;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) throws DateTimeException {
        if (start.isBefore(LocalDateTime.now())) {
            throw new DateTimeException("Date has to be after now");
        }
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        if (end.isBefore(LocalDateTime.now())) {
            throw new DateTimeException("Date has to be after now");
        }
        this.end = end;
    }

    public List<User> getPresentList() {
        return presentList;
    }

    public void addPresent(User user) {
        presentList.add(user);
    }

    public void removePresent(User user) {
        presentList.remove(user);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return subject.getName() + " " + formatter.format(start) + " - "+ formatter.format(end);
    }
}
