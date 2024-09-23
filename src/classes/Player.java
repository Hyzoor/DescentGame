package classes;

public class Player extends Entity{

    //Attributes
    private int gold;

    //Methods
    Player(){
        this.health = 100;
        this.defense = 20;
        this.strength = 25;
        this.gold = 0;
    }

    public int attack1(){
        return (int) (this.getStrength() * 0.2);
    }

    //Gold methods
    public int getGold(){
        return this.gold;
    }

    public void addGold(int newGold){
        this.gold += newGold;
    }

    public void removeGold(int goldToRemove){
        this.gold -= goldToRemove;
    }

    public void showHealth(){
        System.out.println("Jugador: ");
        super.showHealth();
    }
}
