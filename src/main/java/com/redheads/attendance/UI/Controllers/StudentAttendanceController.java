package com.redheads.attendance.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.redheads.attendance.App;
import com.redheads.attendance.BLL.UserManager;
import com.redheads.attendance.UI.Models.UserInfoModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentAttendanceController extends BaseController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label courseLabel;

    private UserInfoModel userInfoModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            userInfoModel = new UserInfoModel(getUserManager());

            nameLabel.textProperty().bind(userInfoModel.userFullNameProperty());
            courseLabel.textProperty().bind(userInfoModel.userCourseProperty());
        });
    }

    public void handleOverview(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}