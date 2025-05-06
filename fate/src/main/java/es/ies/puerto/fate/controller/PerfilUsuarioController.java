package es.ies.puerto.fate.controller;

import es.ies.puerto.fate.abstractas.AbstractController;
import es.ies.puerto.fate.model.UsuarioEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PerfilUsuarioController extends AbstractController {
    @FXML
    private TextField textFieldUser;

    @FXML
    private TextField textFieldPasswordUser;

    @FXML
    private TextField textFieldNombre2;

    @FXML
    private TextField textFieldEmail3;

    @FXML
    private Button atrasButton;

    UsuarioEntity usuarioEntity;

    /**
     * Metodo para inicializar los idiomas
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    public PerfilUsuarioController() {
        System.out.println("Second");
    }

    /**
     * Metodo para cargar los datos
     * 
     * @param usuario
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.usuarioEntity = usuario;
        cargarDatos();
    }

    /**
     * Meetodo para comprobar que los datos no son null
     */
    private void cargarDatos() {
        if (usuarioEntity != null) {
            textFieldUser.setText(usuarioEntity.getNombreUsuario());
            textFieldPasswordUser.setText(usuarioEntity.getContrasenia());
            textFieldNombre2.setText(usuarioEntity.getNombre());
            textFieldEmail3.setText(usuarioEntity.getEmail());
        }
    }

    /**
     * Metodo para volver atras
     */
    @FXML
    protected void onClickVolver() {
        cambiar(atrasButton, "/login");
    }

}
