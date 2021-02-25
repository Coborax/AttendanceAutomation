package com.redheads.attendance.DAL;

import com.redheads.attendance.BE.Subject;
import com.redheads.attendance.BE.UserTypeException;

import java.util.List;

public interface ISubjectDAO {

    /**
     * Returns all subjects
     * @return
     */
    List<Subject> getSubjects();

}
