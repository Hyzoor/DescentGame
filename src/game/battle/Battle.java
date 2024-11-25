package game.battle;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.PanelManager;
import game.characters.Enemy;
import game.characters.Player;

/**
 * This class manages the battle between player and enemies,
 * manages turns and shows results
 */
public class Battle {

    //Attributes
    private Player player;
    private Enemy enemy;
    private Timer timer;
    private boolean isPlayersTurn;

    /**
     * Battle class constructor
     *
     * @param newPlayer
     * @param newEnemy
     */
    public Battle(Player newPlayer, Enemy newEnemy) {
        isPlayersTurn = true;
        setPlayer(newPlayer);
        setEnemy(newEnemy);
        initializeTimer();
    }

    /**
     * Changes turn while player and enemy aren't dead
     */
    public void rotate() {
        if (isAnyoneDead()) {
            end();
            return;
        }
        isPlayersTurn = !isPlayersTurn;
    }

    /**
     * When someone dies, check if the player was defeated
     *
     * @return true if player still alive, false otherwise
     */
    public boolean isPlayerWinner() {
        return !player.isDead();
    }

    /**
     * Check if someone is dead
     *
     * @return true if someone is dead
     */
    public boolean isAnyoneDead() {
        return player.isDead() || enemy.isDead();
    }

    /**
     * Ends the battle:
     */
    public void end() {
        timer.stop();
        PanelManager.getBattlePanel().enablePlayerButtons(false);

        if (isPlayerWinner()) {
            PanelManager.getBattlePanel().addButtonsAfterWinning();
        } else {
            PanelManager.getBattlePanel().addButtonsAfterLosing();
        }

        showResults();
    }

    /**
     * Shows in battle text area the results
     */
    public void showResults() {
        String result;
        if (player.isDead()) {
            result = enemy.toString() + " has defeated you ...";
        } else {
            result = "You have defeated " + enemy.toString() + " ! Good job !";
        }

        PanelManager.getBattlePanel().getBattleTextArea().addText(result);
    }

    private void initializeTimer() {

        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isPlayersTurn) {
                    return;
                }

                enemy.performAttackTo(player);
                rotate();
                PanelManager.getBattlePanel().enablePlayerButtons(true);
            }
        });

        timer.start();
    }


//------------------ SETTERS AND GETTERS ------------------//

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player newPlayer) {
        player = newPlayer;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy newEnemy) {
        enemy = newEnemy;
    }
}
