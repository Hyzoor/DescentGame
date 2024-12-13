package game.enemyfactory;

import game.characters.Enemy;
import game.characters.EnemyType;

import java.util.ArrayList;

public interface EnemyFactory {


    public Enemy create();

    // Cant be private, by default is public static final
    ArrayList<Enemy> enemiesAvailable = new ArrayList<>();

    default void initializeAllEnemiesAvailable() {
        for (Enemies enemy : Enemies.values()) {
            enemiesAvailable.add(new Enemy(enemy.name()));
        }
    }
}
