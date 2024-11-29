package game.enemyfactory;

import game.characters.Enemy;

import java.util.Random;

public class RandomBossFactory implements EnemyFactory{
    private final String[] bosses;

    public RandomBossFactory(){
        bosses = new String[] {"Gollum", "SunlightKeeper"};
    }

    @Override
    public Enemy create(){
        Random random = new Random();
        int i = random.nextInt(bosses.length);

        return new Enemy(bosses[i]);
    }
}
