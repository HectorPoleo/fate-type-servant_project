package es.ies.puerto.fate.controller.abstractas;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Properties;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.model.Conexion;
import es.ies.puerto.fate.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AbstractasController extends Conexion {
    protected UsuarioServiceModel usuarioServiceModel;

    private Properties propertiesIdioma;

    @FXML
    public Text textUsuario;

    @FXML
    public TextField textFieldUsuario;

    @FXML
    public Text textContrasenia;

    @FXML
    public Text textPassword;

    @FXML
    public Text textPassword2;

    @FXML
    public PasswordField textFieldPassword;

    @FXML
    public Text textContrasenia2;

    @FXML
    public PasswordField textFieldPassword2;

    @FXML
    public Text textNombre;

    @FXML
    public TextField textFieldNombre;

    @FXML
    public Text textEmail;

    @FXML
    public TextField textFieldEmail;

    @FXML
    public Text textEmail2;

    @FXML
    public TextField textFieldEmail2;

    @FXML
    public Button atrasButton;

    @FXML
    public Button buttonRegistrar;

    @FXML
    public Button buttonIniciarSesion;

    @FXML
    public Hyperlink link;

    @FXML
    public Text textMensaje;

    @FXML
    public Button buttonRegistrarEmail;

    /**
     * metodo para cambiar el texto de los idiomas
     * 
     * @throws SQLException
     */
    public void cambiarIdioma() throws SQLException {

        if (!(textUsuario == null)) {
            textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
            textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
        }
        if (!(textContrasenia2 == null)) {
            textContrasenia2.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia2"));
        }
        if (!(textNombre == null)) {
            textNombre.setText(ConfigManager.ConfigProperties.getProperty("textNombre"));
        }
        if (!(textEmail == null)) {
            textEmail.setText(ConfigManager.ConfigProperties.getProperty("textEmail"));
        }
        if (!(textEmail2 == null)) {
            textEmail2.setText(ConfigManager.ConfigProperties.getProperty("textEmail2"));
        }
        if (!(textFieldUsuario == null)) {
            textFieldUsuario.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldUsuario"));
        }
        if (!(textFieldPassword == null)) {
            textFieldPassword.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPassword"));
        }
        if (!(textFieldPassword2 == null)) {
            textFieldPassword2.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPassword2"));
        }
        if (!(textFieldEmail == null)) {
            textFieldEmail.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldEmail"));
        }
        if (!(textFieldEmail2 == null)) {
            textFieldEmail2.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldEmail2"));
        }
        if (!(atrasButton == null)) {
            atrasButton.setText(ConfigManager.ConfigProperties.getProperty("atrasButton"));
        }
        if (!(buttonRegistrar == null)) {
            buttonRegistrar.setText(ConfigManager.ConfigProperties.getProperty("buttonRegistrar"));
        }
        if (!(buttonIniciarSesion == null)) {
            buttonIniciarSesion.setText(ConfigManager.ConfigProperties.getProperty("buttonIniciarSesion"));
        }
        if (!(link == null)) {
            link.setText(ConfigManager.ConfigProperties.getProperty("link"));
        }
        if (!(buttonRegistrarEmail == null)) {
            buttonRegistrarEmail.setText(ConfigManager.ConfigProperties.getProperty("buttonRegistrarEmail"));
        }
    }

    /**
     * Set del properties
     * 
     * @param properties
     */
    public void setpropertiesIdioma(Properties properties) {
        propertiesIdioma = properties;
    }

    /**
     * Get del properties
     * 
     * @return
     */
    public Properties getPropertiesIdioma() {
        return propertiesIdioma;
    }

    /**
     * Metodo para cargar los idiomas
     * 
     * @param nombreFichero
     * @param idioma
     * @return
     */
    public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();

        if (nombreFichero == null || idioma == null) {
            return properties;
        }

        String path = "src/main/resources/" + nombreFichero + "-" + idioma + ".properties";

        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Path:" + file.getAbsolutePath());
            return properties;
        }

        try {
            FileInputStream input = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            properties.load(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * Get del UsuarioServiceModel
     * 
     * @return
     * @throws SQLException
     */
    public UsuarioServiceModel getUsuarioServiceModel() throws SQLException {
        return usuarioServiceModel;
    }

    /**
     * Metodo para cambiar las paginas
     * 
     * @param boton
     * @param button
     */
    public void cambiar(Button boton, String button) {
        try {
            Stage stage = (Stage) boton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(button + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(button);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cambiar los hypervinculos
     * 
     * @param boton
     * @param button
     */
    public void cambiarLink(Hyperlink boton, String button) {
        try {
            Stage stage = (Stage) boton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(button + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(button);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cambiar al login
     */
    public void paginaLogin() {
        cambiar(atrasButton, "/login");
    }

    /**
     * Set del UsuarioServiceModel
     * 
     * @param usuarioServiceModel
     * @throws SQLException
     */
    public void setUsuarioServiceModel(UsuarioServiceModel usuarioServiceModel) throws SQLException {
        this.usuarioServiceModel = usuarioServiceModel;
    }

}
