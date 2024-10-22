package game.characters;

import java.util.Map;
import java.util.List;

import ui.PanelManager;

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
    public void performAttackTo(Entity target, int attackNumber) {
        int damage = getStatValue("strength") * attackList.get(attackNumber).getPower();
        target.takeDamage(damage);

        PanelManager.getBattlePanel().addTurnText(
                this.toString(), target.toString(), this.attackList.get(attackNumber).getName(), target.getStatValue("health"));
    }

    public void takeDamage(int damage) {
        if (this.isDead()) {
            return;
        }

        int newHealth = getStatValue("health") - (int) (damage / (getStatValue("defense") * 0.4));
        setStatValue("health", Math.max(newHealth, 0));
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