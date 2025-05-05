package es.ies.puerto.fate.controller;

import java.sql.SQLException;

import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import es.ies.puerto.fate.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SugerenciasController extends AbstractasController{
    @FXML
    public Button inicioButton;

    @FXML
    public TextField textFieldMesage;

    @FXML
    public Text mensaje;

    @FXML
    public void inicioClick(){
        cambiar(inicioButton, "app-init");
    }

    public SugerenciasController(){
    }

    @FXML
    public void sugerenciaClick() throws SQLException{
        usuarioServiceModel = new UsuarioServiceModel();

        if(textFieldMesage == null || textFieldMesage.getText().isEmpty()){
            mensaje.setText("La sugerencia es invalida");
            return;
        }
    }
}
