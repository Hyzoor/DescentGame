package game.characters;

import game.Game;
import game.JsonMapper;
import settings.Settings;

public class Player extends Entity {

    /**
     * Constructs player from a json file using JsonMapper
     *
     * @param newIdentifier String identifier. Has to be named same as the json file
     * @see JsonMapper
     */
    public Player(String newIdentifier) {
        super(newIdentifier);

        String json = Settings.getInstance().getFilePaths().get("playersJsons") + identifier.toLowerCase() + ".json";
        JsonMapper.mapObject(json, this);
    }

    /**
     * Restore full player's health.
     */
    public void restoreHealth() {
        setStatValue("health", getStatValue("max_health"));
    }

}
