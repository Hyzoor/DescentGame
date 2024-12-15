package ui.buttons;
import ui.PanelManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ESCKeyAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        PanelManager.changeToTittleScreen();
    }
}
