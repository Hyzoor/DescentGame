package classes;

public class Main {
    public static void main(String[] args){

        Player player1 = new Player();
        Player player2 = new Player();

        Turn prueba1 = new Turn(player1, player2);

        player2.showHealth();
        prueba1.doDamage(player1.attack1());
        player2.showHealth();

    }

}
