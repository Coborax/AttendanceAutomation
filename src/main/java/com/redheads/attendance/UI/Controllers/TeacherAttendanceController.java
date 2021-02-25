package com.redheads.attendance.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.redheads.attendance.App;
import com.redheads.attendance.UI.Models.AttendanceModel;
import com.redheads.attendance.UI.Models.UserInfoModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import com.redheads.attendance.BE.Lecture;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class TeacherAttendanceController extends BaseController implements Initializable {

    public Button overviewBtn;
    public VBox VBox;
    @FXML
    private Label nameLabel;

    private UserInfoModel userInfoModel;
    private AttendanceModel attendanceModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            userInfoModel = new UserInfoModel(getUserManager(), getUser());
            attendanceModel = new AttendanceModel(getSubjectManager());

            nameLabel.textProperty().bind(userInfoModel.userFullNameProperty());
        });
    }

}
