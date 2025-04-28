package es.ies.puerto.fate.controller;

import java.sql.SQLException;

import es.ies.puerto.fate.abstractas.AbstractController;
import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.model.UsuarioEntity;
import es.ies.puerto.fate.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends AbstractController {

    private final String pathFichero = "src/main/resources/";
    private final String ficheroStr = "idioma-";

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Text textFieldMensaje;

    @FXML
    private Button openInicioButton;

    @FXML
    private Button openRegistrarButton;

    @FXML
    private ComboBox comboIdioma;

    private UsuarioEntity user;
    UsuarioServiceModel usuarioServiceModel;

    public LoginController() {
        usuarioServiceModel = new UsuarioServiceModel();
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.user = usuario;
    }

    @FXML
    public void initialize() {
        comboIdioma.getItems().add("es");
        comboIdioma.getItems().add("en");
        comboIdioma.getItems().add("fr");
        cargarIdioma("es");
        cambiarIdioma();
    }

    @FXML
    protected void seleccionarIdiomaClick() {
        String idioma = comboIdioma.getValue().toString();
        cargarIdioma(idioma);
        cambiarIdioma();

    }

    private void cargarIdioma(String idioma) {

        String path = pathFichero + ficheroStr + idioma + ".properties";
        ConfigManager.ConfigProperties.setPath(path);

    }

    @FXML
    protected void onLoginButtonClick() throws SQLException {

        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty() ||
                textFieldPassword == null || textFieldPassword.getText().isEmpty()) {
            textFieldMensaje.setText("Credenciales invalidas");
            return;
        }

        user = usuarioServiceModel.obtenerUsuarioPorNombreUsuario(textFieldUsuario.getText(),
                textFieldPassword.getText());

        if (user == null) {
            user = usuarioServiceModel.obtenerUsuarioPorEmail(textFieldUsuario.getText(), textFieldPassword.getText());
            return;
        }

        if (user == null) {
            textFieldMensaje.setText("Credenciales invalidas");
            return;
        }
        cambiar(openInicioButton, "app-init");
    }

    @FXML
    protected void openRegistrarClick() {
        cambiar(openRegistrarButton, "registro");
    }
}