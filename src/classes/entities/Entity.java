package classes.entities;

import java.util.List;
import java.util.Map;

import classes.Attack;

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


    //Methods
    public void performAttackTo(Entity target, int attackSelected) {
        int damage = getStrength() * attackList.get(attackSelected).getPower();
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        if (isDead()) {
            return;
        }
        int newHealth = getHealth() - (int) (damage / (getDefense() * 0.4));
        setHealth(Math.max(newHealth, 0));

    }

    public boolean isDead() {
        return getHealth() <= 0;
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

    public void setHealth(int newHealth) {
        stats.put("health", newHealth);
    }

    public void setStrength(int newStrength) {
        stats.put("strength", newStrength);
    }

    public void setDefense(int newDefense) {
        stats.put("defense", newDefense);
    }

    public void setAttackList(List<Attack> newAttackList) {
        attackList = newAttackList;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public int getHealth() {
        return stats.get("health");
    }

    public int getStrength() {
        return stats.get("strength");
    }

    public int getDefense() {
        return stats.get("defense");
    }

    public List<Attack> getAttackList() {
        return attackList;
    }

    public String getIdentifier() {
        return identifier;
    }
}