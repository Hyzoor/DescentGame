package classes;

import java.util.ArrayList;
import java.util.List;

import classes.characters.Enemy;

public class EnemyFactory {

    private final static List<String> enemyList = new ArrayList<>();

    static {
        enemyList.add("Skeleton");
        enemyList.add("Goblin");
    }


    public static Enemy createRandomEnemy() {
        int random = (int) (Math.random() * enemyList.size());
        return new Enemy(enemyList.get(random));
    }
}
