package game;

import settings.Settings;
import ui.PanelManager;
import ui.mainframe.MainFrame;

public class Main {

    public static void main(String[] args){

        Settings settings = Settings.getInstance();
        Game game = Game.getInstance();
        MainFrame mainFrame = MainFrame.getInstance();

        PanelManager.changeToTittleScreen();

    }

}
