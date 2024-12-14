package settings;

import java.util.HashMap;
import java.util.Map;
import game.JsonMapper;

/**
 * Esta clase gestiona la configuración global del juego. Carga las rutas de archivos y los multiplicadores desde un archivo JSON.
 */
public class Settings {

    private static Settings instance;
    private final Map<String, String> filePaths;  // Mapa que almacena las rutas de los archivos utilizados en el juego
    private final Map<String, Double> multipliers;  // Mapa que almacena los multiplicadores de diferentes aspectos del juego

    /**
     * Constructor privado que carga la configuración desde un archivo JSON.
     */
    private Settings() {

        filePaths = new HashMap<>();  // Inicializa el mapa de rutas de archivo
        multipliers = new HashMap<>();  // Inicializa el mapa de multiplicadores

        // Ruta del archivo JSON de configuración
        String jsonFilePath = "src/settings/settings.json";

        // Mapea los datos del archivo JSON a la instancia de Settings
        JsonMapper.mapObject(jsonFilePath, this);
    }

    /**
     * Devuelve la instancia única de la clase Settings. Si aún no existe, la crea.
     *
     * @return La instancia única de Settings
     */
    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    /**
     * Devuelve el mapa de rutas de archivos utilizados en el juego.
     *
     * @return Mapa con las rutas de los archivos
     */
    public Map<String, String> getFilePaths() {
        return filePaths;
    }

    /**
     * Devuelve el mapa de multiplicadores utilizados en el juego.
     *
     * @return Mapa con los multiplicadores
     */
    public Map<String, Double> getMultipliers() {
        return multipliers;
    }

}
