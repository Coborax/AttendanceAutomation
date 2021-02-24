package com.redheads.attendance.UI.Controllers;

import com.redheads.attendance.BLL.UserManager;

public class BaseController {

    private UserManager userManager;

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
