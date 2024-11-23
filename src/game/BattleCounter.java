package game;

public class BattleCounter {

    private static int count;
    private static final int MAX_BATTLES = 10;


    public BattleCounter() {
        count = 0;
    }

    public static void increment() {
        count++;
    }

    public static int get() {
        return count;
    }

    public static void reset() {
        count = 0;
    }

    public static boolean hasReachedMax(){
        return (count == MAX_BATTLES);
    }
}
