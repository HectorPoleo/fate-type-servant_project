package es.ies.puerto.fate.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {
    private String rutaArchivoBD;
    private Connection conexion;

    public Conexion() {
    }
    
    /**
     * Constructor con path de conexion
     * @param unaRutaArchivoBD ruta de verdad
     * @throws SQLException error controlado
     */
    public Conexion(String unaRutaArchivoBD) throws SQLException{
        if(unaRutaArchivoBD == null || unaRutaArchivoBD.isEmpty()){
            throw new SQLException("Fichero es nulo o vacio");
        }
        File file = new File(unaRutaArchivoBD);
        if (!file.exists()){
            throw new SQLException("No existe la base de datos"+rutaArchivoBD);
        }
        rutaArchivoBD = unaRutaArchivoBD;
    }

    /**
     * Funcion que devuelve la conexion a la bbdd
     * @return
     * @throws SQLException
     */
    public Connection conectar() throws SQLException{
        if(conexion!= null){
            return conexion;
        }
        conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaArchivoBD);
        return conexion;
    }

    /**
     * Funcion que cierra la conexion 
     * @throws SQLException
     */
    public void cerrar() throws SQLException{
        if(conexion != null|| !conexion.isClosed()){
            conexion.close();
            conexion = null;
        }
          
    }

    public String getRutaArchivoBD() {
        return this.rutaArchivoBD;
    }

    public void setRutaArchivoBD(String rutaArchivoBD) {
        this.rutaArchivoBD = rutaArchivoBD;
    }

    public Connection getConexion() {
        try {
            if (conexion == null){
                conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaArchivoBD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return this.conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
