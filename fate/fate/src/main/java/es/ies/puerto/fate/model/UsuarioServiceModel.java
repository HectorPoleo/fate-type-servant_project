package es.ies.puerto.fate.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioServiceModel extends Conexion{

    public UsuarioServiceModel(){

    }
    public UsuarioServiceModel(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    public UsuarioEntity obtenerUsuariosEmailOrUsuario(String input) throws SQLException{
        try {
        String sql = "SELECT * FROM Usuario" + "where email="+input+"or usuario="+input+" ";
        ArrayList<UsuarioEntity> usuarios = obtenerUsuario(sql);
            if(usuarios.isEmpty()){
            return null;
            }
        return usuarios.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<UsuarioEntity> obtenerUsuarios() throws SQLException{
            String sql = "SELECT * FROM Usuario;";
            return obtenerUsuario(sql);
    }

    public ArrayList<UsuarioEntity> obtenerUsuario(String sql) throws SQLException{
        ArrayList<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
        try {
            PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM Usuario");
            ResultSet resultado = sentencia.executeQuery();

            while(resultado.next()){
                String nombreStr = resultado.getString("nombre");
                String contraseniaStr = resultado.getString("contrasenia");
                String emailStr = resultado.getString("email");
                UsuarioEntity usuarioEntity = new UsuarioEntity(emailStr, nombreStr, contraseniaStr);
                usuarios.add(usuarioEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            cerrar();
        }
    return usuarios;
    }
    
}
