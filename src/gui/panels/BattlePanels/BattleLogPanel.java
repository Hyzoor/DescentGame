package gui.panels.BattlePanels;

import javax.swing.*;
import java.awt.*;

public class BattleLogPanel extends JPanel {

    BattleLogPanel(){
        this.setLayout(new BorderLayout());

//        JTextPane logText = new JTextPane();
        JTextArea logText = new JTextArea();
        logText.setEditable(false);
        logText.setText("REGISTRO DE TEXTO DE LA BATALLA ACTUAL");

        this.add(logText, BorderLayout.CENTER);
    }
}
