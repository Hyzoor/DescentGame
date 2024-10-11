package classes.entities;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Attack;

public class Player extends Entity {

    //Attributes
    private int maxHealth;

    //Constructor
    public Player(String newIdentifier) {
        super(newIdentifier, new HashMap<String, Integer>(), new ArrayList<Attack>());
        createPlayer();
    }


    //Methods
    public void restoreHealth(){
        setHealth(maxHealth);
    }

    private void createPlayer() {

        switch (this.getIdentifier().toUpperCase()) {

            case "KNIGHT":
                maxHealth = 50;
                setHealth(maxHealth);
                setStrength(20);
                setDefense(30);
                attackList.add(new Attack("Sword Strike", 2));
                attackList.add(new Attack("Drain Mace", 5));
                attackList.add(new Attack("Shield Reduction", 1));
                attackList.add(new Attack("Attack number 4", 3));
                break;

            case "MAGE":
                maxHealth = 45;
                setHealth(maxHealth);
                setStrength(30);
                setDefense(25);
                attackList.add(new Attack("Ice Beam", 3));
                attackList.add(new Attack("Thunder", 7));
                attackList.add(new Attack("Magic Shield", 1));
                attackList.add(new Attack("Attack number 4", 1));
                break;

            case "ROGUE":
                maxHealth = 40;
                setHealth(maxHealth);
                setStrength(40);
                setDefense(20);
                attackList.add(new Attack("Payday", 4));
                attackList.add(new Attack("Lethal Knife", 8));
                attackList.add(new Attack("Stealth", 1));
                attackList.add(new Attack("Attack number 4", 2));
                break;
        }
    }
}
