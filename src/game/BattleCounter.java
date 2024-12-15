package game;

import settings.Settings;

/**
 * A class that keeps track of the number of battles.
 * It has a maximum battle limit and provides functionality to increment, reset, and check if the max number of battles is reached.
 */
public class BattleCounter {

    private int count;
    private final int maxBattles;

    /**
     * Constructor for BattleCounter.
     * Initializes the counter to 0 by calling {@link #reset()}.
     */
    public BattleCounter() {
        maxBattles = Settings.getInstance().getNumberOfBattlesToWin();
        reset();
    }

    /**
     * Increments the battle count by 1.
     */
    public void increment() {
        count++;
    }

    /**
     * Gets the current number of battles.
     *
     * @return The current battle count.
     */
    public int get() {
        return count;
    }

    /**
     * Gets the maximum number of battles allowed.
     *
     * @return The maximum battle count.
     */
    public int getMaxBattles() {
        return maxBattles;
    }

    /**
     * Resets the battle count to 0.
     */
    public void reset() {
        count = 0;
    }

    /**
     * Checks if the maximum number of battles has been reached.
     *
     * @return true if the battle count is equal to the maximum allowed, false otherwise.
     */
    public boolean hasReachedMax() {
        return (count == maxBattles);
    }
}
