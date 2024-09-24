package classes;

public class Main {
    public static void main(String[] args){

        Knight knight1 = new Knight();
        Mage mage1 = new Mage();
        Rogue rogue1 = new Rogue();

        Turn turno1 = new Turn(knight1, mage1);

        mage1.showHealth();
        turno1.performAttack();
        mage1.showHealth();

        turno1.setDefender(rogue1);
        rogue1.showHealth();
        turno1.performAttack();
        rogue1.showHealth();


    }

}
