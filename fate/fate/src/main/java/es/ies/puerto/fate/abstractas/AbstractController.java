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

public class AbstractController{

    static final String Path_Db = "src/main/resources/usuarios.db";

    private UsuarioServiceModel usuarioServiceModel;

    private Properties propertiesIdioma;

    File file = new File(Path_Db);

    public AbstractController(){
        try {
            usuarioServiceModel = new UsuarioServiceModel(Path_Db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Text textUsuario;

    @FXML
    public Text textContrasenia;

    public void cambiarIdioma() {
        textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
        textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
    }

    public UsuarioServiceModel getUsuarioServiceModel() {
        return this.usuarioServiceModel;
    }

    public Properties getPropertiesIdioma() {
        return this.propertiesIdioma;
    }

    public Text getTextUsuario() {
        return this.textUsuario;
    }

    public Text getTextContrasenia() {
        return this.textContrasenia;
    }
    
    public void cambiar(Button boton, String button) {
         try {
            Stage stage = (Stage) boton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(button+".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle(button);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}