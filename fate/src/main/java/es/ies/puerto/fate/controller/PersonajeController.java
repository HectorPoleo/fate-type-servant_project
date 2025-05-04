package es.ies.puerto.fate.controller;

import java.sql.SQLException;

import es.ies.puerto.fate.config.ConfigManager;
import es.ies.puerto.fate.controller.abstractas.AbstractasController;
import es.ies.puerto.fate.model.PersonajeEntity;
import es.ies.puerto.fate.model.PersonajeService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class PersonajeController extends AbstractasController {

    @FXML
    private Button volverAtras;

    @FXML
    private TextArea info;

    @FXML
    private Text personajeNombre;

    @FXML
    private ImageView image;

    public void initialize() throws SQLException{
        PersonajeEntity personaje = new PersonajeService().obtenerPersonajePorID(ConfigManager.ConfigProperties.getId());
        info.setText(personaje.getDescripcion());
        personajeNombre.setText(personaje.getNombre());
        image.setImage(new Image("file:src/main/resources/Image/" + personaje.getImagen()));
    }

    @FXML
    protected void volverClick(){
        cambiar(volverAtras, "/categoria");
    }
}
