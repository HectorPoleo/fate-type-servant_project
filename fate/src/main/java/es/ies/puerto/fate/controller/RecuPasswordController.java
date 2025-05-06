package es.ies.puerto.fate.controller;

import java.sql.SQLException;

import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import es.ies.puerto.fate.model.UsuarioEntity;
import es.ies.puerto.fate.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RecuPasswordController extends AbstractasController{
    @FXML
    public Button volverButton;

    @FXML
    public TextField emailRecu;

    @FXML
    public Button recuperarButton;

    @FXML
    public Text advertencia;

    /**
     * Metodo que llama a la clase cmabiar de los metodos abstractos para volver al login
     */
    @FXML
    public void volverClick(){
        cambiar(volverButton, "/login");
    }

    /**
     * Metodo para recuperar la contrasenia de la base de datos
     */
    @FXML
    public void  recuperarClick() throws SQLException{
        if(emailRecu.getText() == null || emailRecu.getText().isEmpty()){
            advertencia.setText("Email invalido");
            return;
        }
        UsuarioEntity usuarioEntity = new UsuarioServiceModel().obtenerUsuarioSOLOPorEmail(emailRecu.getText());
        if (usuarioEntity == null){
            advertencia.setText("No existe ningun usuario con ese email");
            return;
        }
        advertencia.setText("Su contraseña es: " + usuarioEntity.getContrasenia());
    }
}
