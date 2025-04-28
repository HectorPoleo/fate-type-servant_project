package es.ies.puerto.fate.controller;

import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController extends AbstractasController{
    
    @FXML
    private Button loginButton;

    @FXML
    private Button registroButton;

    @FXML
    protected void onLoginClick() {
        cambiar(loginButton, "login");
    }

    @FXML
    protected void onRegistroButton() {
        cambiar(registroButton, "registro");
    }
}
