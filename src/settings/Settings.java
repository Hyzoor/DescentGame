package settings;

import java.util.HashMap;
import java.util.Map;

import game.JsonMapper;

public class Settings {

    private static Settings instance;
    private final Map<String, String> filePaths;
    private final Map<String, Double> multipliers;

    private Settings() {

        filePaths = new HashMap<>();
        multipliers = new HashMap<>();

        String jsonFilePath = "src/settings/settings.json";
        JsonMapper.mapObject(jsonFilePath, this);
    }

    public static Settings getInstance(){
        if(instance == null){
            instance = new Settings();
        }

        return instance;
    }

    public Map<String, String> getFilePaths() {
        return filePaths;
    }

    public Map<String, Double> getMultipliers() {
        return multipliers;
    }

}
