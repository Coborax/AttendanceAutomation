package com.redheads.attendance.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import com.calendarfx.view.DayView;
import com.calendarfx.view.WeekView;
import com.calendarfx.view.page.DayPage;
import com.calendarfx.view.page.WeekPage;
import com.redheads.attendance.App;
import com.redheads.attendance.UI.Models.AttendanceModel;
import com.redheads.attendance.UI.Models.UserInfoModel;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import com.redheads.attendance.BE.Lecture;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class StudentAttendanceController extends BaseController implements Initializable {

    public Button overviewBtn;
    public VBox VBox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label courseLabel;
    @FXML
    private ListView lecturesListView;
    @FXML
    private DayPage calendarView;

    private UserInfoModel userInfoModel;
    private AttendanceModel attendanceModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            userInfoModel = new UserInfoModel(getUserManager(), getUser());
            attendanceModel = new AttendanceModel(getSubjectManager());

            nameLabel.textProperty().bind(userInfoModel.userFullNameProperty());
            courseLabel.textProperty().bind(userInfoModel.userCourseProperty());

            //lecturesListView.setItems(attendanceModel.getLecturesForUser(userInfoModel.getUser()));

            /*lecturesListView.setCellFactory(CheckBoxListCell.forListView((Callback<Lecture, ObservableValue<Boolean>>) item -> {
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
            }));*/

            System.out.println("Done setting up");

            com.calendarfx.model.Calendar present = new com.calendarfx.model.Calendar("Attended Classes");
            com.calendarfx.model.Calendar notPresent = new com.calendarfx.model.Calendar("Non Attended Classes");
            com.calendarfx.model.Calendar future = new com.calendarfx.model.Calendar("Future Classes");

            present.setStyle(Calendar.Style.STYLE1);
            notPresent.setStyle(Calendar.Style.STYLE2);
            future.setStyle(Calendar.Style.STYLE3);

            for (Lecture l : attendanceModel.getLecturesForUser(userInfoModel.getUser())) {
                Entry<Lecture> entry = new Entry<Lecture>(l.getSubject().getName());
                entry.setUserObject(l);
                entry.setInterval(l.getStart(), l.getEnd());

                if (l.getStart().isAfter(LocalDateTime.now())) {
                    future.addEntry(entry);
                } else if (l.getPresentList().contains(userInfoModel.getUser())) {
                    present.addEntry(entry);
                } else {
                    notPresent.addEntry(entry);
                }
            }

            CalendarSource calendarSource = new CalendarSource(userInfoModel.getUserFullName() + " - Classes");
            calendarSource.getCalendars().addAll(present, notPresent, future);

            ContextMenu menu = new ContextMenu();
            MenuItem item = new MenuItem("Mark Present");
            item.setOnAction((e) -> {
                System.out.println("Wew");
                /*Lecture lecture = ((Entry<Lecture>)e.ge).getUserObject();
                if (!attendanceModel.validateAttendance(userInfoModel.getUser(), lecture, true)) {
                    System.out.println("User: " + userInfoModel.getUser().getUsername() + " cannot be present, because the class hasn't started yet");
                } else {
                    System.out.println("User: " + userInfoModel.getUser().getUsername() + " is marked present");
                }*/
            });

            menu.getItems().add(item);

            calendarView.getCalendarSources().addAll(calendarSource);
            calendarView.setRequestedTime(LocalTime.now());
            calendarView.setEntryContextMenuCallback(param -> menu);
        });

        // If a teacher is logged in, remove the overview button.
        //if (user == User.UserType.TEACHER) {
        //   VBox.getChildren().remove(overviewBtn);
        //}
    }

    public void handleOverview(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }

}
