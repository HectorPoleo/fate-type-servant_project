package es.ies.puerto.fate.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class PersonajeService extends Conexion {

    Set<PersonajeEntity> personajeEntity;

    public PersonajeService() throws SQLException {
        super();
    }

    /**
     * Metodo para obtener personaje
     * 
     * @param sql
     * @return
     * @throws SQLException
     */
    public ArrayList<PersonajeEntity> obtenerPersonaje(String sql) {
        ArrayList<PersonajeEntity> peersonajes = new ArrayList<PersonajeEntity>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Integer idInt = resultado.getInt("ID");
                String usuarioStr = resultado.getString("personajeNombre");
                String infoStr = resultado.getString("personajeInfo");
                String imageStr = resultado.getString("personajeImage");
                PersonajeEntity personajeModel = new PersonajeEntity(idInt, usuarioStr, infoStr, imageStr);
                peersonajes.add(personajeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cerrar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return peersonajes;
    }

    /**
     * Metodo para obtener todos los Personajes
     * 
     * @return
     * @throws SQLException
     */
    public ArrayList<PersonajeEntity> obtenerTodosPersonajes() {
        String sql = "SELECT * FROM personaje";
        return obtenerPersonaje(sql);
    }

    /**
     * Metodo para obtener personajes por id
     * 
     * @param ID
     * @return
     * @throws SQLException
     */
    public PersonajeEntity obtenerPersonajePorID(Integer ID) {
        String sql = "SELECT * FROM personaje WHERE ID = '" + ID + "'";
        ArrayList<PersonajeEntity> personajes = obtenerPersonaje(sql);
        if (personajes.isEmpty()) {
            return null;
        }
        return personajes.get(0);
    }
}
