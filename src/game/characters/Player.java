package game.characters;

import game.JsonMapper;

public class Player extends Entity {

    /**
     * Constructs player from a json file using JsonMapper
     * @see JsonMapper
     * @param newIdentifier String identifier. Has to be named same as the json file
     */
    public Player(String newIdentifier) {
        super(newIdentifier);

        String jsonFilepath = "src/game/characters/data/players/" + identifier.toLowerCase() + ".json";
        JsonMapper.mapEntity(jsonFilepath, this);
    }


    /**
     * Restore full player's health.
     */
    public void restoreHealth() {
        setStatValue("health", getStatValue("max_health"));
    }

}
