package es.ies.puerto.fate.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {

    private String PATH_DB;
    protected Connection connection;

    /**
     * Constructor vacio
     */
    public Conexion() {
        PATH_DB = "src/main/resources/bbdd/usuarios.db";
    }

    /**
     * Constructor con path de conexion
     * 
     * @param unaRutaArchivoBD ruta de la bbdd
     * @throws SQLException error controlado
     */
    public Conexion(String unaRutaArchivoBD) throws SQLException {
        try {
            if (unaRutaArchivoBD == null || unaRutaArchivoBD.isEmpty()) {
                throw new SQLException("El fichero es nullo o vacio");
            }
            File file = new File(unaRutaArchivoBD);
            if (!file.exists()) {
                throw new SQLException("No existe la bbdd:" + unaRutaArchivoBD);
            }
            PATH_DB = unaRutaArchivoBD;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getRutaArchivoBD() {
        return this.PATH_DB;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + PATH_DB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.connection;
    }

    /**
     * Funcion que abre la conexion a la bbdd
     *
     * @return
     * @throws SQLException
     */
    public Connection conectar() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + PATH_DB);
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Funcion que cierra la conexion de bbdd
     *
     */
    public void cerrar() {
        try {
            if (connection != null || !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
