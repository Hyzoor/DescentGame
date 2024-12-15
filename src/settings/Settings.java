package settings;

import java.util.HashMap;
import java.util.Map;
import game.JsonMapper;

/**
 * This class manages the global configuration of the game. Loads file paths and the multipliers from a JSON file
 */
public class Settings {

    private static Settings instance;
    private final Map<String, String> filePaths;
    private final Map<String, Double> multipliers;

    /**
     * Private constructor that loads the configuration from JSON file.
     */
    private Settings() {

        filePaths = new HashMap<>();
        multipliers = new HashMap<>();

        String jsonFilePath = "src/settings/settings.json";

        JsonMapper.mapObject(jsonFilePath, this);
    }

    /**
     * Returns the unique instance of the Settings class. If doesn't exist already, it instantiates one
     *
     * @return The unique instance of Settings
     */
    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    /**
     * Returns map with the file's paths that are used in the game
     *
     * @return Map with file's paths
     */
    public Map<String, String> getFilePaths() {
        return filePaths;
    }

    /**
     * Returns map with the multipliers that are used in the game
     *
     * @return Map with the multipliers
     */
    public Map<String, Double> getMultipliers() {
        return multipliers;
    }

}
