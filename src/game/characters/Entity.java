package game.characters;

import java.util.Map;
import java.util.List;

import game.Game;
import settings.Settings;
import ui.PanelManager;

/**
 * Abstract class representing an entity with stats, an attack list, and a unique identifier.
 */
abstract public class Entity {

    // Attributes
    /**
     * The unique string identifier of the entity.
     */
    protected String identifier;

    /**
     * A map containing the stats of the entity, where the key is the stat name and the value is its value.
     */
    protected Map<String, Integer> stats;

    /**
     * A list of attacks available to the entity.
     */
    protected List<Attack> attackList;

    /**
     * Constructs an Entity object by initializing its identifier.
     *
     * @param newIdentifier a unique string identifier for the entity.
     */
    public Entity(String newIdentifier) {
        setIdentifier(newIdentifier);
    }

    /**
     * Calculates damage, reduces the target's health, and updates the battle text area with the turn info.
     *
     * @param target the target entity receiving the damage.
     * @param attack the attack performed by this entity.
     */
    public void performAttackTo(Entity target, Attack attack) {
        int damage = getStatValue("strength") * attack.getPower();
        target.takeDamage(damage);

        PanelManager.getBattlePanel().getBattleTextArea().addTurnText(
                this.toString(), target.toString(), attack.getName(), target.getStatValue("health"));
    }

    /**
     * Reduces the entity's health based on the damage received.
     *
     * @param damage the amount of damage to be taken.
     */
    public void takeDamage(int damage) {
        if (this.isDead()) {
            return;
        }

        int damageTaken = (int) (damage / (getStatValue("defense") * Settings.getInstance().getMultipliers().get("defense")));
        int newHealth = getStatValue("health") - damageTaken;

        setStatValue("health", Math.max(newHealth, 0));
    }

    /**
     * Checks if the entity is dead.
     *
     * @return true if the entity's health is 0 or less, false otherwise.
     */
    public boolean isDead() {
        return getStatValue("health") <= 0;
    }

    /**
     * Returns the string representation of the entity.
     *
     * @return the entity's identifier.
     */
    @Override
    public String toString() {
        return identifier;
    }

    //------------------ SETTERS AND GETTERS ------------------//

    /**
     * Sets the entity's identifier.
     *
     * @param newIdentifier the new identifier for the entity.
     */
    public void setIdentifier(String newIdentifier) {
        identifier = newIdentifier;
    }

    /**
     * Sets the entity's stats.
     *
     * @param newStats a map containing the entity's stats.
     */
    public void setStats(Map<String, Integer> newStats) {
        stats = newStats;
    }

    /**
     * Sets the value of a specific stat.
     *
     * @param stat     the name of the stat to update.
     * @param newValue the new value for the stat.
     */
    public void setStatValue(String stat, int newValue) {
        stats.put(stat.toLowerCase(), newValue);
    }

    /**
     * Sets the entity's attack list.
     *
     * @param newAttackList a list of attacks available to the entity.
     */
    public void setAttackList(List<Attack> newAttackList) {
        attackList = newAttackList;
    }

    /**
     * Gets the value of a specific stat.
     *
     * @param stat the name of the stat to retrieve.
     * @return the value of the specified stat.
     */
    public int getStatValue(String stat) {
        return stats.get(stat.toLowerCase());
    }

    /**
     * Gets the entity's attack list.
     *
     * @return the list of attacks available to the entity.
     */
    public List<Attack> getAttackList() {
        return attackList;
    }

    /**
     * Gets the entity's stats.
     *
     * @return a map containing the entity's stats.
     */
    public Map<String, Integer> getStats() {
        return stats;
    }
}
