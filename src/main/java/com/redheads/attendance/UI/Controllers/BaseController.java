package com.redheads.attendance.UI.Controllers;

import com.redheads.attendance.BE.Subject;
import com.redheads.attendance.BLL.SubjectManager;
import com.redheads.attendance.BLL.UserManager;

public class BaseController {

    private UserManager userManager;
    private SubjectManager subjectManager;

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public SubjectManager getSubjectManager() {
        return subjectManager;
    }

    public void setSubjectManager(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }
}
