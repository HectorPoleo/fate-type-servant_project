package es.ies.puerto.fate.controller;

import java.io.IOException;
import java.sql.SQLException;

import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController extends AbstractasController {

    @FXML
    private Button origenButton;

    @FXML
    private Button categoriaButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button registroButton;

    /**
     * Metodo para cambiar a la pagina de login
     */
    @FXML
    protected void onLoginClick() throws IOException {
        cambiar(loginButton, "/login");
    }

    /**
     * Metodo para cambiar a la pagina de registro
     */
    @FXML
    protected void onRegistroButton() throws IOException {
        cambiar(registroButton, "/registro");
    }

    /**
     * Metodo para cambiar a la pagina de categoria
     */
    @FXML
    protected void categoriaCilck() throws IOException {
        cambiar(categoriaButton, "/categoria");
    }

    /**
     * Metodo para cambiar a la pagina de origen
     */
    @FXML
    protected void origenClick() throws IOException {
        cambiar(origenButton, "/origen");
    }

    /**
     * Metodo para inicializar la base de datos
     * 
     * @throws SQLException
     */
    @FXML
    public void initialize() throws SQLException {
        if (ConfigManager.ConfigProperties.getPath() == null) {
            ConfigManager.ConfigProperties.setPath("src/main/resources/bbdd/idioma-es.properties");
        }
    }
}
