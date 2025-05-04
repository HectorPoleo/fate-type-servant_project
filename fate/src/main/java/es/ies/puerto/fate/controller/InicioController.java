package es.ies.puerto.fate.controller;

import java.io.IOException;

import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController extends AbstractasController{

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
}
