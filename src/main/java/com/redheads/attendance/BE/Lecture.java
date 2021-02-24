package com.redheads.attendance.BE;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lecture {

    private Subject subject;
    private LocalDateTime start;
    private LocalDateTime end;

    public Lecture(Subject subject, LocalDateTime start, LocalDateTime end) throws UserTypeException {
        setSubject(subject);
        setStart(start);
        setEnd(end);
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        return subject.getName() + " " + formatter.format(start) + " - "+ formatter.format(end);
    }
}
