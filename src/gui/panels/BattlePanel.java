package gui.panels;

import gui.buttons.AttackButton;
import gui.helpers.CharacterImage;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {

    AttackButton attackButton1, attackButton2, attackButton3;
    private String characterClass;

    public BattlePanel(String characterClass) {
        this.characterClass = characterClass;


        this.setLayout(new BorderLayout());


        ImageIcon characterIcon = CharacterImage.getCharacterImage(characterClass);


        if (characterIcon != null) {
            Image image = characterIcon.getImage();
            Image scaledImage = image.getScaledInstance(100, 150, Image.SCALE_SMOOTH); // Cambia el tamaño aquí
            characterIcon = new ImageIcon(scaledImage);
        } else {

            characterIcon = new ImageIcon(); //
        }

        JLabel characterLabel = new JLabel(characterIcon);
        characterLabel.setHorizontalAlignment(JLabel.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));

        attackButton1 = new AttackButton(0);
        attackButton2 = new AttackButton(1);
        attackButton3 = new AttackButton(2);

        buttonPanel.add(attackButton1);
        buttonPanel.add(attackButton2);
        buttonPanel.add(attackButton3);


        this.add(characterLabel, BorderLayout.WEST);


        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
