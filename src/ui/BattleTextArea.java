package ui;

import game.BattleCounter;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Custom text area used to display battle-related information in the game.
 * This class handles text display, the battle count, and visual styling (like background and font).
 */
public class BattleTextArea extends JTextArea {

    /**
     * Background image for the battle text area.
     */
    private Image background;

    /**
     * Constructor that initializes the battle text area and sets its background.
     */
    public BattleTextArea(){
        initializeBattleTextArea();
        setBackground();
        this.setOpaque(false); // Make the text area transparent
    }

    /**
     * Adds a new turn's battle text (attacker, defender, attack name, and defender's health).
     *
     * @param attacker The name of the attacker.
     * @param defender The name of the defender.
     * @param attack The attack used by the attacker.
     * @param defenderHealth The health of the defender after the attack.
     */
    public void addTurnText(String attacker, String defender, String attack, int defenderHealth) {
        addText(String.format("%s has used %s.\n%s health: %d\n", attacker, attack, defender, defenderHealth));
    }

    /**
     * Adds a new line of text to the battle text area.
     *
     * @param newText The text to be added.
     */
    public void addText(String newText) {
        this.append(newText);  // Append the new text to the existing content
        this.append("\n"); // Add a new line after the text
    }

    /**
     * Clears the text in the battle text area.
     */
    public void clearText() {
        this.setText("");  // Reset the text area
    }

    /**
     * Displays the current battle count.
     */
    public void showBattleCount() {
        clearText();  // Clear previous text
        addText("Actual Battle : " + Game.getInstance().getBattleCounter().get());  // Show the current battle count
    }

    /**
     * Sets the background image for the battle text area.
     */
    private void setBackground(){
        background = new ImageIcon("src/resources/images/textbox-background.png").getImage();  // Set the background image
    }

    /**
     * Initializes the battle text area (e.g., setting font, margin, and other properties).
     */
    private void initializeBattleTextArea() {
        Font customFont;
        try{
            // Load the custom font from file
            File fontFile = new File("src/resources/fonts/superlegendboy.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile); // Create a font object from the file
            this.setFont(customFont.deriveFont(Font.PLAIN, 16));  // Apply the font to the text area

        } catch(IOException e){
            System.err.print("Couldnt open font file correctly");
            System.err.print(e.getMessage());
        } catch (FontFormatException e){
            System.err.print("Font file doesn't have the correct format, couldn't load it");
            System.err.print(e.getMessage());
        }

        // Set additional properties for the text area
        this.setMargin(new Insets(0,0,0,0));  // Remove margins
        this.setEditable(false);  // Make the text area non-editable
        this.setCaretPosition(this.getDocument().getLength());  // Set the caret to the end of the document
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));  // Set the border for the text area
    }

    /**
     * Paints the component with the background image and any additional custom painting.
     *
     * @param g The Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);  // Draw the background image
        }

        super.paintComponent(g);  // Perform the default painting behavior (painting the text area content)
    }
}
