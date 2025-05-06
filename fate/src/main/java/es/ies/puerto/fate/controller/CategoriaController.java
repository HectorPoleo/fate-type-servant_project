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

    /**
     * Metodo para cambiar a la pagina de a la pagina principal de la app
     */
    @FXML
    protected void volverAtrasClick() {
        cambiar(volverAtras, "/app-init");
    }

    /**
     * Metodo para acceder a la pagina de saber (Se pronuncia seiber)
     */
    @FXML
    protected void saberClick() {
        ConfigManager.ConfigProperties.setId(1);
        cambiarLink(saber, "/personaje");
    }

    /**
     * Metodo para acceder a la pagina de lancer
     */
    @FXML
    protected void lancerClick() {
        ConfigManager.ConfigProperties.setId(3);
        cambiarLink(lancer, "/personaje");
    }

    /**
     * Metodo para acceder a la pagina de archer
     */
    @FXML
    protected void archerClick() {
        ConfigManager.ConfigProperties.setId(2);
        cambiarLink(archer, "/personaje");
    }
}
