module es.ies.puerto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.sql;

    opens es.ies.puerto to javafx.fxml;
    exports es.ies.puerto;
    exports es.ies.puerto.fate;
    exports es.ies.puerto.fate.controller;
    exports es.ies.puerto.fate.controller.abstractas;
    exports es.ies.puerto.fate.abstractas;
    opens es.ies.puerto.fate.controller to javafx.fxml;
}