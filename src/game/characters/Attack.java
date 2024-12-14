package game.characters;

/**
 * Represents an attack with a name and a power value.
 */
public class Attack {

    /**
     * The name of the attack.
     */
    private String name;

    /**
     * The power of the attack.
     */
    private int power;

    //------------------ SETTERS AND GETTERS ------------------//

    /**
     * Sets the name of the attack.
     *
     * @param newName the new name of the attack.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Sets the power of the attack.
     *
     * @param newPower the new power value of the attack.
     */
    public void setPower(int newPower) {
        power = newPower;
    }

    /**
     * Gets the name of the attack.
     *
     * @return the name of the attack.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the power of the attack.
     *
     * @return the power of the attack.
     */
    public int getPower() {
        return power;
    }
}
