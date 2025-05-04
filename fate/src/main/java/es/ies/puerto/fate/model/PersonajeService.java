package es.ies.puerto.fate.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PersonajeService extends Conexion{
    
    Set<PersonajeEntity> personajeEntity;
    public PersonajeService() throws SQLException {
        super();
    }

    public ArrayList<PersonajeEntity> obtenerPersonaje(String sql) throws SQLException {
        ArrayList<PersonajeEntity> peersonajes = new ArrayList<PersonajeEntity>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Integer idInt = resultado.getInt("ID");
                String usuarioStr = resultado.getString("personajeNombre");
                String infoStr = resultado.getString("personajeInfo");
                String imageStr = resultado.getString("personajeImage");
                PersonajeEntity personajeModel = new PersonajeEntity(idInt,usuarioStr, infoStr, imageStr);
                peersonajes.add(personajeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return peersonajes;
    }

    public ArrayList<PersonajeEntity> obtenerTodosPersonajes() throws SQLException {
        String sql = "SELECT * FROM personaje";
        return obtenerPersonaje(sql);
    }

    public PersonajeEntity obtenerPersonajePorID(Integer ID) throws SQLException{
        String sql = "SELECT * FROM personaje WHERE ID = '" + ID + "'";
        ArrayList<PersonajeEntity> personajes = obtenerPersonaje(sql);
        if (personajes.isEmpty()) {
            return null;
        }
        return personajes.get(0);
    }
}
