package classes;

public class Attack {

    private String name;
    private int power;

    public Attack(String newName, int newPower){
        setName(newName);
        setPower(newPower);
    }

    //Setters and Getters
    public void setName(String newName){
        name = newName;
    }

    public void setPower(int newPower){
        power = newPower;
    }

    public String getName(){
        return name;
    }

    public int getPower(){
        return power;

    }
}
