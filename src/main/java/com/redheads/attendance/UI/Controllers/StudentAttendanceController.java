package com.redheads.attendance.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.redheads.attendance.App;
import com.redheads.attendance.BE.Lecture;
import com.redheads.attendance.BLL.SubjectManager;
import com.redheads.attendance.BLL.UserManager;
import com.redheads.attendance.UI.Models.AttendanceModel;
import com.redheads.attendance.UI.Models.UserInfoModel;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;

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

            lecturesListView.setCellFactory(CheckBoxListCell.forListView((Callback<Lecture, ObservableValue<Boolean>>) item -> {
                BooleanProperty observable = new SimpleBooleanProperty();
                observable.addListener((obs, oldVal, newVal) -> {
                    if (!attendanceModel.validateAttendance(userInfoModel.getUser(), item, newVal)) {
                        Platform.runLater(() -> observable.setValue(false));
                        System.out.println("User: " + userInfoModel.getUser().getUsername() + " cannot be present, because the class hasn't started yet");
                    } else {
                        System.out.println("User: " + userInfoModel.getUser().getUsername() + " is marked present");
                    }
                });
                return observable ;
            }));

            System.out.println("Done setting up");
        });
    }
}
