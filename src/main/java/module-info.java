module com.redheads {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.redheads to javafx.fxml;
    exports com.redheads;
}