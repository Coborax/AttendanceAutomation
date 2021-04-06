package com.redheads.attendance.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.redheads.attendance.App;
import com.redheads.attendance.BE.Subject;
import com.redheads.attendance.BE.User;
import com.redheads.attendance.BLL.UserManager;
import com.redheads.attendance.UI.Models.AttendanceModel;
import com.redheads.attendance.UI.Models.AttendanceOverviewModel;
import com.redheads.attendance.UI.Models.UserInfoModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import com.redheads.attendance.BE.Lecture;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class TeacherAttendanceController extends BaseController implements Initializable {

    public Button overviewBtn;
    public VBox VBox;
    @FXML
    private Label nameLabel;
    @FXML
    private ComboBox<Subject> subjectList;
    @FXML
    private TableView attendanceTableView;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, Float> absenceColumn;
    @FXML
    private TableColumn<User, String> mostAbsenceColumn;

    private UserInfoModel userInfoModel;
    private AttendanceOverviewModel attendanceModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            UserManager.getInstance().updateAllUsersAttendance();

            userInfoModel = new UserInfoModel(getUserManager(), getUser());
            attendanceModel = new AttendanceOverviewModel(getSubjectManager());

            nameLabel.textProperty().bind(userInfoModel.userFullNameProperty());

            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            absenceColumn.setCellValueFactory(new PropertyValueFactory<>("absence"));
            mostAbsenceColumn.setCellValueFactory(new PropertyValueFactory<>("mostAbsent"));

            subjectList.setItems(attendanceModel.getSubjects(getUser()));
            subjectList.getSelectionModel().selectedItemProperty().addListener((observableVal, oldVal, newVal) -> {
                attendanceTableView.setItems(attendanceModel.getStudentsInSubject(newVal));
            });
        });
    }

}
