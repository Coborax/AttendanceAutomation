package com.redheads.attendance.UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SecondaryController extends BaseController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private ComboBox boxClass;
    private ArrayList<String> subjects = new ArrayList<String>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subjects.add("SCO"); // TODO: ADD SUBJECTS BY STUDENT
        boxClass.getItems().addAll(subjects);
    }

    public void drawChart(ActionEvent actionEvent) {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Absent",9.5),
                new PieChart.Data("Present", 90.5)); // TODO: ADD ABSENT BY STUDENT
        pieChart.setData(pieData);
    }


}