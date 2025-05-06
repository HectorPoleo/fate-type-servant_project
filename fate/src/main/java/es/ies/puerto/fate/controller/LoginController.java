package es.ies.puerto.fate.controller;

import java.sql.SQLException;

import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import es.ies.puerto.fate.model.UsuarioEntity;
import es.ies.puerto.fate.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends AbstractasController {

    private final String pathFichero = "src/main/resources/bbdd/";
    private final String ficheroStr = "idioma-";

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Text textFieldMensaje;

    @FXML
    private Button buttonIniciarSesion;

    @FXML
    private Button buttonRegistrar;

    @FXML
    private Button recuPasswordButton;

    @FXML
    private ComboBox comboIdioma;

    private UsuarioEntity user;
    UsuarioServiceModel usuarioServiceModel;

    /**
     * Metodo para iniciar usuarioServiceModel
     * 
     * @throws SQLException
     */
    public LoginController() throws SQLException {
        usuarioServiceModel = new UsuarioServiceModel();
    }

    /**
     * Set del usuario
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.user = usuario;
    }

    /**
     * Metodo para inicializar tanto los idiomas como el usuarioServiceModel
     * 
     * @throws SQLException
     */
    @FXML
    public void initialize() throws SQLException {
        comboIdioma.getItems().add("es");
        comboIdioma.getItems().add("en");
        comboIdioma.getItems().add("fr");
        cambiarIdioma();
        this.usuarioServiceModel = new UsuarioServiceModel();
    }

    /**
     * Metodo para seleccionar los idiomas disponibles
     * 
     * @throws SQLException
     */
    @FXML
    protected void seleccionarIdiomaClick() throws SQLException {
        String idioma = comboIdioma.getValue().toString();
        cargarIdioma(idioma);
        cambiarIdioma();
        this.usuarioServiceModel = new UsuarioServiceModel();

    }

    /**
     * Metodo para cargar los idiomas
     * 
     * @param idioma
     */
    private void cargarIdioma(String idioma) {
        String path = pathFichero + ficheroStr + idioma + ".properties";
        ConfigManager.ConfigProperties.setPath(path);
    }

    /**
     * Metodo para verificar que el login es correcto y mandarte a la pantalla de
     * sugerencias
     * 
     * @throws SQLException
     */
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
        cambiar(buttonIniciarSesion, "/sugerencias");
    }

    /**
     * Metodo para cambiar a la pagina de registro
     */
    @FXML
    protected void openRegistrarClick() {
        cambiar(buttonRegistrar, "/registro");
    }

    /**
     * Metodo para cambiar a la pagina de recuPassword
     */
    @FXML
    protected void recuPasswordClick() {
        cambiar(recuPasswordButton, "/recuPassword");
    }
}