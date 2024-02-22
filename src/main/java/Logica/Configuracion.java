package Logica;

import java.io.InputStream;
import java.util.Properties;

public class Configuracion {
    private Properties prop;

    public Configuracion(String archivo) {
        prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(archivo)) {
            if (input == null) {
                System.out.println("Lo siento, no se encuentra el archivo de configuración.");
                return;
            }

            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String obtenerValor(String clave) {
        return prop.getProperty(clave);
    }
}
