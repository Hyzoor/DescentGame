package ui.mainframe;

import javax.swing.*;
import java.awt.*;

import game.Game;
import ui.PanelManager;

public class MainFrame extends JFrame {

    private static MainFrame instance;

    // Constructor
    private MainFrame() {

        setTitle("The Descent - RogueLike Game");
        setSize(1200, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        setVisible(true);
    }

    //Singleton
    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

}

