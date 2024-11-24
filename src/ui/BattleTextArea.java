package ui;

import game.BattleCounter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BattleTextArea extends JTextArea {

    private Image background;

    public BattleTextArea(){
        initializeBattleTextArea();
        setBackground();
        this.setOpaque(false);
    }

    public void addTurnText(String attacker, String defender, String attack, int defenderHealth) {
        addText(String.format("%s has used %s.\n%s health: %d\n", attacker, attack, defender, defenderHealth));
    }

    public void addText(String newText) {
        this.append(newText);
        this.append("\n");
    }

    public void clearText() {
        this.setText("");
    }

    public void showBattleCount() {
        clearText();
        addText("Actual Battle : " + BattleCounter.get());
    }

    private void setBackground(){
        background = new ImageIcon("src/resources/images/textbox-background.png").getImage();
    }

    private void initializeBattleTextArea() {

        Font customFont;
        try{

            File fontFile = new File("src/resources/fonts/superlegendboy.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            customFont = customFont.deriveFont(Font.PLAIN, 16);
            this.setFont(customFont);

        } catch(IOException e){
            System.err.print("Couldnt open font file correctly");
            System.err.print(e.getMessage());
        } catch (FontFormatException e){
            System.err.print("Font file dont have the correct format, couldnt load it");
            System.err.print(e.getMessage());
        }

        this.setMargin(new Insets(0,0,0,0));
        this.setEditable(false);
        this.setCaretPosition(this.getDocument().getLength());
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }

        super.paintComponent(g);
    }
}
