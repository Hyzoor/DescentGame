package game.characters;

/**
 * Represents an attack with its name and amount of power
 */
public class Attack {

    //Attributes
    private String name;
    private int power;


    /**
     * Default constructor
     */
    public Attack(){
        //Needed for JSON Mapping
    }

//------------------ SETTERS AND GETTERS ------------------//

    public void setName(String newName) {
        name = newName;
    }

    public void setPower(int newPower) {
        power = newPower;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
