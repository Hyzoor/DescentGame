package classes.characters;

public class Attack {

    //Attributes
    private String name;
    private int power;

    //Constructor
    public Attack(String newName, int newPower) {
        setName(newName);
        setPower(newPower);
    }

    public Attack(){
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
