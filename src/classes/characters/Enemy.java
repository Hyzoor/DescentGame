package classes.characters;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Enemy extends Entity {

    public Enemy(String newIdentifier) {
        super(newIdentifier, new HashMap<String, Integer>(), new ArrayList<Attack>());
        createEnemy();
    }


    public void createEnemy() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Player aux = objectMapper.readValue(new File("src/classes/characters/data/enemies/" + identifier.toLowerCase() + ".json"), Player.class);

            this.attackList = aux.getAttackList();
            this.stats = aux.getStats();

        } catch (JsonMappingException e) {
            System.out.println("Error while mapping JSON " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error processing the file.json " + e.getMessage());
        }
    }

    public void performAttackTo(Entity target) {

        int attack = attackSelector();
        super.performAttackTo(target, attack);

    }

    private int attackSelector() {
        return (int) (Math.random() * attackList.size());
    }
}
