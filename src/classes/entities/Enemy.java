package classes.entities;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Attack;
import classes.Game;
import classes.PanelManager;

public class Enemy extends Entity {

    public Enemy(String newIdentifier) {
        super(newIdentifier, new HashMap<String, Integer>(), new ArrayList<Attack>());
        createEnemy();
    }


    public void createEnemy() {

        switch (this.getIdentifier().toUpperCase()) {

            case "DEFAULT":
                setHealth(60);
                setStrength(20);
                setDefense(30);
                attackList.add(new Attack("Default Enemy Attack 1", 2));
                attackList.add(new Attack("Default Enemy Attack 2", 3));
                attackList.add(new Attack("Default Enemy Attack 3", 4));
                attackList.add(new Attack("Default Enemy Attack 4", 5));
                break;

            case "SKELETON":
                break;

        }
    }

    public void performAttackTo(Entity target) {

        int attack = attackSelector();
        super.performAttackTo(target, attack);

        PanelManager.getBattlePanel().addText(
                String.format("%s has used %s. %s health: %d",
                        Game.instance.getBattle().getEnemy().toString(),
                        Game.instance.getBattle().getEnemy().getAttackList().get(attack).getName(),
                        Game.instance.getBattle().getPlayer().toString(),
                        Game.instance.getBattle().getPlayer().getHealth()
                )
        );
    }

    private int attackSelector() {
        return (int) (Math.random() * attackList.size());
    }
}
