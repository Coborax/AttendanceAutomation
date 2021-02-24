package com.redheads.attendance;

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

    private static UserManager userManager = new UserManager();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("studentAttendance"), 640, 480);
        stage.setScene(scene);
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

        return root;
    }

    public static void main(String[] args) {
        launch();
    }

}