package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;

public class CreditsPanel extends JPanel {

    public CreditsPanel(){
        this.setBackground(Color.black);
        this.add(new JLabel("fin"), BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }


}
