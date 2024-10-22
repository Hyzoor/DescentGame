package game.characters;

import game.JsonMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Entity {

    //Constructor
    public Player(String newIdentifier) {
        super(newIdentifier, new HashMap<>(), new ArrayList<>(4));

        String jsonFilepath = "src/classes/characters/data/players/" + identifier.toLowerCase() + ".json";
        JsonMapper.mapEntity(jsonFilepath, this);
    }


    //Methods
    public void restoreHealth() {
        setStatValue("health", getStatValue("max_health"));
    }

}
