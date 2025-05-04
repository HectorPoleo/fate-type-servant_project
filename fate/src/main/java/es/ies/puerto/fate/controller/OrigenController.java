package es.ies.puerto.fate.controller;

import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class OrigenController extends AbstractasController{
    @FXML
    private Button volverAtrasButton;

    @FXML
    private Hyperlink categoriaLink;

    @FXML
    protected void volverAtrasClick(){
        cambiar(volverAtrasButton, "/app-init");
    }

    @FXML
    public void categoriaClick() {
        cambiarLink(categoriaLink, "/categoria");
    }
}
