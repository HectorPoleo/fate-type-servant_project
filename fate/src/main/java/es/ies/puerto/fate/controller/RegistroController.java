package es.ies.puerto.fate.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import  es.ies.puerto.fate.controller.abstractas.AbstractasController;
import es.ies.puerto.fate.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegistroController extends AbstractasController{
     
    @FXML
    public TextField textFiledUsuario;

    @FXML
    public Text textMensaje;

    @FXML
    public Button buttonRegistrar;

    @FXML 
    public PasswordField textFieldPassword;

    @FXML 
    public PasswordField textFieldPasswordRepit;

    @FXML
    public Text textUsuario;

    @FXML
    public Text textNombre;

    @FXML
    public Text textContrasenia;

    @FXML
    public Text textEmail;

    @FXML
    public Text textEmail2;

    @FXML
    public Button atrasButton;

    UsuarioServiceModel usuarioServiceModel;

    public RegistroController(){
    }

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    @FXML
    protected void onClickRegistrar()  {
        usuarioServiceModel = getUsuarioServiceModel();
        
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textMensaje.setText("¡El nombre de usuario no puede ser nulo o vacio!");
            return;
        }

        if (usuarioServiceModel.verificarUsuario(textFieldUsuario.getText())) {
            textMensaje.setText("El usuario ya esta registrado.");
            return;
        }

        if (textFieldPassword == null || textFieldPassword.getText().isEmpty()|| textFieldPassword2 == null || textFieldPassword2.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }

        if (textFieldNombre == null || textFieldNombre.getText().isEmpty()) {
            textMensaje.setText("¡El nombre no puede ser nulo o vacio!");
            return;
        }

        if (textFieldEmail == null || textFieldEmail.getText().isEmpty()|| textFieldEmail2 == null || textFieldEmail2.getText().isEmpty()) {
            textMensaje.setText("¡El email no puede ser nulo o vacio!");
            return;
        }

        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(textFieldEmail.getText());
        if (!m.matches()) {
            textMensaje.setText("El correo electrónico no es válido.");
            return;
        }

        if (usuarioServiceModel.verificarEmail(textFieldEmail2.getText())) {
            textMensaje.setText("El email ya esta registrado.");
            return;
        }

        if (!textFieldPassword.getText().equals(textFieldPassword2.getText())) {
            textMensaje.setText("¡La passwords no son iguales!");
            return;
        }

        boolean registro = usuarioServiceModel.aniadirUsuario(textFieldUsuario.getText(), textFieldNombre.getText(), textFieldPassword.getText(), textFieldEmail.getText());
        if (registro == false) {
            textMensaje.setText("Ya hay una cuenta con ese usuario e email");
        } else{
            textMensaje.setText("¡Usuario registrado!");
        }
    }

        @FXML
    protected void volverAtrasClick(){
        paginaLogin();
    }
}
