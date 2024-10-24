package game.characters;

import game.JsonMapper;

public class Player extends Entity {

    //Constructor
    public Player(String newIdentifier) {
        super(newIdentifier);

        String jsonFilepath = "src/game/characters/data/players/" + identifier.toLowerCase() + ".json";
        JsonMapper.mapEntity(jsonFilepath, this);
    }


    //Methods
    public void restoreHealth() {
        setStatValue("health", getStatValue("max_health"));
    }

}
