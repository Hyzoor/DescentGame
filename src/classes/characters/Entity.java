package classes.characters;

import java.util.List;
import java.util.Map;

abstract public class Entity {


    //Attributes
    protected String identifier;
    protected Map<String, Integer> stats;
    protected List<Attack> attackList;


    //Constructor
    public Entity(String newIdentifier, Map<String, Integer> newStats, List<Attack> newAttackList) {
        setIdentifier(newIdentifier);
        setStats(newStats);
        setAttackList(newAttackList);
    }

    public Entity() {
    }


    //Methods
    public void performAttackTo(Entity target, int attackSelected) {
        int damage = getStatValue("strength") * attackList.get(attackSelected).getPower();
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        if (isDead()) {
            setStatValue("health", 0);
            return;
        }

        int newHealth = getStatValue("health") - (int) (damage / (getStatValue("defense") * 0.4));
        setStatValue("health", newHealth);

    }

    public boolean isDead() {
        return getStatValue("health") <= 0;
    }

    public void increaseStat(String stat, int value) {
        setStatValue(stat, getStatValue(stat) + value); //Actual value + value
    }

    @Override
    public String toString() {
        return getIdentifier();
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

    public Map<String, Integer> getStats() {
        return stats;
    }

    public int getStatValue(String stat) {
        return stats.get(stat.toLowerCase());
    }

    public List<Attack> getAttackList() {
        return attackList;
    }

    public String getIdentifier() {
        return identifier;
    }
}