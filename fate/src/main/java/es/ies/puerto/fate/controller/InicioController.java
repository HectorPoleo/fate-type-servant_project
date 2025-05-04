package es.ies.puerto.fate.controller;

import java.io.IOException;
import java.sql.SQLException;

import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController extends AbstractasController{

    @FXML
    private Button origenButton;

    @FXML
    private Button categoriaButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button registroButton;

    @FXML
    protected void onLoginClick() throws IOException {
        cambiar(loginButton, "/login");
    }

    @FXML
    protected void onRegistroButton() throws IOException {
        cambiar(registroButton, "/registro");
    }

    @FXML
    protected void categoriaCilck() throws IOException {
        cambiar(categoriaButton, "/categoria");
    }

    @FXML
    protected void origenClick() throws IOException {
        cambiar(origenButton, "/origen");
    }

    @FXML
    public void initialize() throws SQLException {
        if(ConfigManager.ConfigProperties.getPath() == null){
            ConfigManager.ConfigProperties.setPath("src/main/resources/bbdd/idioma-es.properties");
        }
    }
}
