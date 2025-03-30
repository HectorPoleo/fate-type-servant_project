module es.ies.puerto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens es.ies.puerto to javafx.fxml;
    opens es.ies.puerto.controller to javafx.fxml;
}
