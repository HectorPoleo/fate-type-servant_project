package es.ies.puerto.fate.controller;

import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class CategoriaController extends AbstractasController {
    @FXML
    private Button volverAtras;

    @FXML
    private Hyperlink saber;

    @FXML
    private Hyperlink lancer;

    @FXML
    private Hyperlink archer;

    @FXML
    protected void volverAtrasClick() {
        cambiar(volverAtras, "/app-init");
    }

    @FXML
    protected void saberClick() {
        ConfigManager.ConfigProperties.setId(1);
        cambiarLink(saber, "/personaje");
    }

    @FXML
    protected void lancerClick() {
        ConfigManager.ConfigProperties.setId(3);
        cambiarLink(lancer, "/personaje");
    }

    @FXML
    protected void archerClick() {
        ConfigManager.ConfigProperties.setId(2);
        cambiarLink(archer, "/personaje");
    }
}
