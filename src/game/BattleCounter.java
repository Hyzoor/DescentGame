package game;

public class BattleCounter {

    private  int count;
    private final int maxBattles = 6;


    public BattleCounter() {
        reset();
    }

    public void increment() {
        count++;
    }

    public int get() {
        return count;
    }

    public int getMaxBattles(){
        return maxBattles;
    }

    public void reset() {
        count = 0;
    }

    public boolean hasReachedMax(){
        return (count == maxBattles);
    }
}
