package game.characters;

import game.Game;
import game.JsonMapper;
import settings.Settings;

/**
 * Represents a player character in the game.
 */
public class Player extends Entity {

    /**
     * Constructs a Player object by mapping its attributes from a JSON file using JsonMapper.
     *
     * @param newIdentifier a unique string identifier. It must match the name of the corresponding JSON file.
     * @see JsonMapper
     */
    public Player(String newIdentifier) {
        super(newIdentifier);

        String json = Settings.getInstance().getFilePaths().get("playersJsons") + identifier.toLowerCase() + ".json";
        JsonMapper.mapObject(json, this);
    }

    /**
     * Restores the player's health to its maximum value.
     */
    public void restoreHealth() {
        setStatValue("health", getStatValue("max_health"));
    }
}
