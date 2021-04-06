package com.redheads.attendance.DAL;

import com.redheads.attendance.BE.Subject;

import java.util.List;

public interface ISubjectDAO {

    /**
     * Returns all subjects
     * @return
     */
    List<Subject> getSubjects();

    void saveSubject(Subject subject);



}
