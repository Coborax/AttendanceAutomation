package com.redheads.attendance.UI.Controllers;

import com.redheads.attendance.App;
import com.redheads.attendance.UI.Models.UserInfoModel;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class SecondaryController extends BaseController implements Initializable {

    @FXML
    private PieChart pieChart;
    private float presence;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DecimalFormat df = new DecimalFormat("#.#");
        Platform.runLater(() -> {
            presence = getSubjectManager().getAttendancePercent(getUser());

            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                    new PieChart.Data("Absent", Float.parseFloat(df.format(100.00-presence))),
                    new PieChart.Data("Present", presence));

            pieChart.setData(pieData);

            // Displays values
            pieData.forEach(data ->
                    data.nameProperty().bind(
                            Bindings.concat(
                                    data.getName(), " ", data.pieValueProperty(), "%"
                            )
                    )
            );
        });
    }

    public void handleClose(ActionEvent actionEvent) throws IOException {
        App.setRoot("studentAttendance");
    }
}