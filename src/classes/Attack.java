package classes;

public class Attack {

    private String name;
    private int attackPower;

    Attack(String newName, int newAttackPower){
        setName(newName);
        setAttackPower(newAttackPower);
    }
gi
    //Setters and Getters
    public void setName(String newName){
        name = newName;
    }

    public void setAttackPower(int newAttackPower){
        attackPower = newAttackPower;
    }

    public String getName(){
        return name;
    }

    public int getAttackPower(){
        return attackPower;
    }
}
