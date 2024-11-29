package game.characters;

import java.util.Map;
import java.util.List;

import game.Game;
import settings.Settings;
import ui.PanelManager;

/**
 * Abstract class that represents an entity with stats, an attack list and a string that identifies it
 */
abstract public class Entity {


    //Attributes
    protected String identifier;
    protected Map<String, Integer> stats;
    protected List<Attack> attackList;


    /**
     * Constructs an entity object by default setting just the identifier
     *
     * @param newIdentifier String that identifies the entity
     */
    public Entity(String newIdentifier) {
        setIdentifier(newIdentifier);
    }

    /**
     * Calculates the damage, reduces target health and shows in battle text area the turn info
     *
     * @param target    Entity who receives the damage
     * @param attack    Attack selected to perform
     */
    public void performAttackTo(Entity target, Attack attack) {
        int damage = getStatValue("strength") * attack.getPower();
        target.takeDamage(damage);

        PanelManager.getBattlePanel().getBattleTextArea().addTurnText(
                this.toString(), target.toString(), attack.getName(), target.getStatValue("health"));
    }

    /**
     * From an amount of damage, reduces entity's health
     *
     * @param damage Amount of damage to be taken
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
     * Checks if entity is dead
     *
     * @return true if health is 0 or less
     */
    public boolean isDead() {
        return getStatValue("health") <= 0;
    }

    /**
     * Overrides toString method
     *
     * @return entity's string identifier
     */
    @Override
    public String toString() {
        return identifier;
    }


    //------------------ SETTERS AND GETTERS ------------------//

    public void setIdentifier(String newIdentifier) {
        identifier = newIdentifier;
    }

    public void setStats(Map<String, Integer> _stats) {
        stats = _stats;
    }

    public void setStatValue(String stat, int newValue) {
        stats.put(stat.toLowerCase(), newValue);
    }

    public void setAttackList(List<Attack> newAttackList) {
        attackList = newAttackList;
    }

    public int getStatValue(String stat) {
        return stats.get(stat.toLowerCase());
    }

    public List<Attack> getAttackList() {
        return attackList;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

}