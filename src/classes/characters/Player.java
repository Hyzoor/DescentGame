package classes.characters;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Entity {

    //Constructor
    public Player(String newIdentifier) {
        super(newIdentifier, new HashMap<>(), new ArrayList<>(4));
        createPlayer();
    }

    public Player() {
    }


    //Methods
    public void restoreHealth() {
        setStatValue("health", getStatValue("max_health"));
    }

    private void createPlayer() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Player aux = objectMapper.readValue(new File("src/classes/characters/data/players/" + identifier.toLowerCase() + ".json"), Player.class);

            this.attackList = aux.getAttackList();
            this.stats = aux.getStats();

        } catch (JsonMappingException e) {
            System.out.println("Error while mapping JSON " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error processing the file.json " + e.getMessage());
        }

    }
}
