package gui.helpers;

import javax.swing.*;

public class CharacterImage {

    public static ImageIcon getCharacterImage(String characterClass) {
        switch (characterClass) {
            case "Knight":
                return new ImageIcon("images/knight_skin.png");
            case "Mage":
                return new ImageIcon("images/mage_skin.png");
            case "Rogue":
                return new ImageIcon("images/rogue_skin.png");
            default:
                return null;
        }
    }
}
