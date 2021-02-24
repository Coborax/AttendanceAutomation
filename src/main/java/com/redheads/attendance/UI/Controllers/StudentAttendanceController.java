package com.redheads.attendance.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.redheads.attendance.App;
import com.redheads.attendance.BLL.SubjectManager;
import com.redheads.attendance.BLL.UserManager;
import com.redheads.attendance.UI.Models.AttendanceModel;
import com.redheads.attendance.UI.Models.UserInfoModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class StudentAttendanceController extends BaseController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label courseLabel;
    @FXML
    private ListView lecturesListView;

    private UserInfoModel userInfoModel;
    private AttendanceModel attendanceModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            userInfoModel = new UserInfoModel(getUserManager());
            attendanceModel = new AttendanceModel(getSubjectManager());

            nameLabel.textProperty().bind(userInfoModel.userFullNameProperty());
            courseLabel.textProperty().bind(userInfoModel.userCourseProperty());

            lecturesListView.setItems(attendanceModel.getLecturesForUser(userInfoModel.getUser()));
        });
    }
}
