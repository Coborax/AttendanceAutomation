package com.redheads.attendance;

import com.redheads.attendance.BE.UserTypeException;
import com.redheads.attendance.BLL.SubjectManager;
import com.redheads.attendance.BLL.UserManager;
import com.redheads.attendance.UI.Controllers.BaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static UserManager userManager = UserManager.getInstance();
    public static SubjectManager subjectManager = SubjectManager.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("EASV Attendance - Beta v0.01 - Developed by: Redhead Inc");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();

        BaseController controller = fxmlLoader.getController();
        controller.setUserManager(userManager);
        controller.setSubjectManager(subjectManager);

        return root;
    }

    public static void main(String[] args) {
        launch();
    }

}