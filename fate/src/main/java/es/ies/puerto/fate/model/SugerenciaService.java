package es.ies.puerto.fate.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import es.ies.puerto.fate.model.*;

public class SugerenciaService extends Conexion{
    
    Set<SugerenciaEntity> sugerencias; 

    public ArrayList<SugerenciaEntity> obtenerTodasSugerencias() throws SQLException {
        String sql = "SELECT * FROM sugerencia";
        return obtenerSugerencia(sql);
    }

    public ArrayList<SugerenciaEntity> obtenerSugerencia(String sql) throws SQLException {
        ArrayList<SugerenciaEntity> sugerencias = new ArrayList<SugerenciaEntity>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Integer idStr = resultado.getInt("ID");
                String textStr = resultado.getString("sugerencia");
                SugerenciaEntity sugerenciaModel = new SugerenciaEntity(idStr,textStr);
                sugerencias.add(sugerenciaModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return sugerencias;
    }

    public SugerenciaEntity obtenerSugerenciaPorId(Integer ID) throws SQLException{
        String sql = "SELECT * FROM sugerencia WHERE ID = '" + ID + "'";
        ArrayList<SugerenciaEntity> sugerencias = obtenerSugerencia(sql);
        if (sugerencias.isEmpty()) {
            return null;
        }
        return sugerencias.get(0);
    }

    public boolean aniadirSugerencia(String sugerencia) {
        try {
            PreparedStatement sentencia = getConnection().prepareStatement("INSERT INTO sugerencia (sugerencia) values (?)");
            sentencia.setString(1, sugerencia);
            sentencia.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSugerencia(String sugerencia) {
        try {
            PreparedStatement sentencia = getConnection().prepareStatement("DELETE FROM sugerencia WHERE values (?)");
            sentencia.setString(1, sugerencia);
            sentencia.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
