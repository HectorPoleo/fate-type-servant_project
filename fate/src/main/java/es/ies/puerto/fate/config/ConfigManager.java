package es.ies.puerto.fate.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigManager {
    public static class ConfigProperties {

        private static String path;

        private static int idPersonaje;

        /**
         * Get del id
         * 
         * @return
         */
        public static int getId() {
            return idPersonaje;
        }

        /**
         * Set del id
         * 
         * @param id
         */
        public static void setId(int id) {
            idPersonaje = id;
        }

        /**
         * Get del path
         * 
         * @return
         */
        public static String getPath() {
            return path;
        }

        /**
         * Iniciar el properties
         */
        private static final Properties properties = new Properties();

        /**
         * Metodo estatico para obtener una propiedad
         **/
        public static String getProperty(String key) {
            return properties.getProperty(key);
        }

        /**
         * Set del path
         * 
         * @param rutaPath
         */
        public static void setPath(String rutaPath) {
            System.out.println("Dentro del setPath");
            File file = new File(rutaPath);
            if (!file.exists() || !file.isFile()) {
                System.out.println("Path:" + file.getAbsolutePath());
            }
            path = rutaPath;

            try {
                System.out.println("Dentro del ConfigProperties");
                FileInputStream input = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(input, "UTF-8");
                properties.load(isr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
