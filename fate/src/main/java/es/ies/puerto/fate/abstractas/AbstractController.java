package es.ies.puerto.fate.abstractas;

import java.io.File;
import java.util.Properties;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.model.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AbstractController {

    static final String Path_Db = "src/main/resources/usuarios.db";

    protected UsuarioServiceModel usuarioServiceModel;

    private Properties propertiesIdioma;

    File file = new File(Path_Db);

    /**
     * Clase del abstractController
     */
    public AbstractController() {
        try {
            usuarioServiceModel = new UsuarioServiceModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Text textUsuario;

    @FXML
    public Text textContrasenia;

    /**
     * Contructor del cambiarIdioma
     */
    public void cambiarIdioma() {
        textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
        textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
    }

    /**
     * Get del UsuarioServiceModel
     * 
     * @return
     */
    public UsuarioServiceModel getUsuarioServiceModel() {
        return this.usuarioServiceModel;
    }

    /**
     * Get del properties
     * 
     * @return
     */
    public Properties getPropertiesIdioma() {
        return this.propertiesIdioma;
    }

    /**
     * Get de Usuario
     * 
     * @return
     */
    public Text getTextUsuario() {
        return this.textUsuario;
    }

    /**
     * Get de contraseñia
     * 
     * @return
     */
    public Text getTextContrasenia() {
        return this.textContrasenia;
    }

    /**
     * Metodo para cambiar de pagina
     * 
     * @param boton
     * @param button
     */
    public void cambiar(Button boton, String button) {
        try {
            Stage stage = (Stage) boton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(button + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle(button);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}