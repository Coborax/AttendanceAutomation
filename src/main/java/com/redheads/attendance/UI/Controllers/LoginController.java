package com.redheads.attendance.UI.Controllers;

import com.redheads.attendance.App;
import com.redheads.attendance.BE.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends BaseController {

    @FXML
    private TextField username;

    @FXML
    void login(ActionEvent event) {
        System.out.println("Trying to login");
        for (User u : getUserManager().getUsers()) {
            if (u.getUsername().equals(username.getText())) {
                setUser(u);
                try {
                    switch (u.getType()) {
                        case STUDENT -> App.setRoot("studentAttendance");
                        case TEACHER -> App.setRoot("teacherAttendance");
                    }
                } catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
            }
        }
    }

}
