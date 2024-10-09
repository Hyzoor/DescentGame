package gui.panels.MainPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.MainFrame;

public class TitleScreen extends JPanel {

    public TitleScreen(MainFrame mainFrame) {
        this.setLayout(new BorderLayout());


        JLabel titleLabel = new JLabel("The Descent", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrar el botón

        // Cargar y escalar la imagen
        ImageIcon originalIcon = new ImageIcon("src/resources/images/Play.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Botón de Play
        JButton playButton = new JButton(scaledIcon);
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setFocusPainted(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeToClassSelectionPanel();
            }
        });

        buttonPanel.add(playButton);
        this.add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 20, 0));
    }
}
