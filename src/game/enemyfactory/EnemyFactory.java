package game.enemyfactory;

import game.characters.Enemy;
import game.characters.EnemyType;

import java.util.ArrayList;

/**
 * Interface for creating enemies in the game.
 */
public interface EnemyFactory {

    /**
     * Creates a new enemy instance.
     *
     * @return The newly created enemy.
     */
    public Enemy create();

    /**
     * List of all enemies available in the game.
     * By default, this is a static and final field.
     */
    ArrayList<Enemy> enemiesAvailable = new ArrayList<>();

    /**
     * Initializes the list of all available enemies by adding an instance
     * of each enemy type defined in the {@link Enemies} enumeration.
     */
    default void initializeAllEnemiesAvailable() {
        for (Enemies enemy : Enemies.values()) {
            enemiesAvailable.add(new Enemy(enemy.name()));
        }
    }
}
