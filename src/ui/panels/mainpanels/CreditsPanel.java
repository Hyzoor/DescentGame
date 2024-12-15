package ui.panels.mainpanels;

import settings.Settings;
import ui.buttons.ESCKeyAction;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Represents the credits panel in the game interface.
 * <p>
 * This panel is displayed at the end of the game, showing the credits
 */
public class CreditsPanel extends JPanel {

    private final Image gifImage;

    /**
     * Creates a new CreditsPanel with a black background and a label displaying "fin".
     */
    public CreditsPanel() {
        this.setLayout(new BorderLayout());

        String imagesPath = Settings.getInstance().getFilePaths().get("images");
        gifImage = new ImageIcon(imagesPath + "endGame.gif").getImage();

        JTextPane textCredits = new JTextPane();
        initializeText(textCredits);


        ESCKeyAction keyAction = new ESCKeyAction();
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escPressed");
        this.getActionMap().put("escPressed", keyAction);

        //Needed to listen to key events
        this.setFocusable(true);
        this.requestFocusInWindow();


        this.add(textCredits, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(gifImage, 0, 0, getWidth(), getHeight(), this);
    }

    private void setCustomFont(JTextPane text) {
        Font customFont;
        try {
            // Load the custom font from file
            String fontsPath = Settings.getInstance().getFilePaths().get("fonts");
            File fontFile = new File(fontsPath + "superlegendboy.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            text.setFont(customFont.deriveFont(Font.PLAIN, 16));

        } catch (IOException e) {
            System.err.print("Couldnt open font file correctly");
            System.err.print(e.getMessage());
        } catch (FontFormatException e) {
            System.err.print("Font file doesn't have the correct format, couldn't load it");
            System.err.print(e.getMessage());
        }
    }

    private void centerText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    private void initializeText(JTextPane textCredits) {
        textCredits.setText("The journey was long, but you have persevered. The darkness bows to your will, tarnished" +
                "\nThank you, brave soul, for venturing through these forsaken lands ..." +
                "\n\nPress ESC key to go back to title screen brave traveler");

        setCustomFont(textCredits);
        textCredits.setForeground(Color.LIGHT_GRAY);
        textCredits.setOpaque(false);
        textCredits.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        centerText(textCredits);
    }
}
