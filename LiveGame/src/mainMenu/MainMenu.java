package mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainMenu extends JFrame {

    private Image backgroundImage;
    private JButton settingsButton;
    private JButton gameplayButton;
    private JButton leaderboardButton;
    private JLabel resultLabel;

    public MainMenu() {
        // Load the background image from the classpath
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/DesertImageLive.jpg")); // Ensure the path is correct
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB); // Empty image as fallback
        }

        // Set up the frame
        setTitle("Game Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window to full screen
        setLayout(new BorderLayout()); // Use BorderLayout to handle positioning of components

        // Create a custom panel with background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to center components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create a JPanel for the resultLabel with a background color
        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black background
        labelPanel.setOpaque(true);
        labelPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the label

        // Create a JLabel to display instructions
        resultLabel = new JLabel("Main Menu");
        resultLabel.setForeground(Color.WHITE); // Set text color to white for visibility
        labelPanel.add(resultLabel); // Add the label to the panel

        // Add labelPanel to the backgroundPanel
        gbc.gridx = 0;
        gbc.gridy = 0; // Place at the top
        backgroundPanel.add(labelPanel, gbc);

        // Create "Settings" button
        settingsButton = new JButton("Settings");
        settingsButton.setPreferredSize(new Dimension(150, 50)); // Set size of the button
        settingsButton.setForeground(Color.WHITE); // Set text color to white
        settingsButton.setBackground(Color.BLACK); // Set button background color for better contrast
        gbc.gridy = 1; // Place below the labelPanel
        backgroundPanel.add(settingsButton, gbc);

        // Create "Gameplay" button
        gameplayButton = new JButton("Gameplay");
        gameplayButton.setPreferredSize(new Dimension(150, 50)); // Set size of the button
        gameplayButton.setForeground(Color.WHITE); // Set text color to white
        gameplayButton.setBackground(Color.BLACK); // Set button background color for better contrast
        gbc.gridy = 2; // Place below the settingsButton
        backgroundPanel.add(gameplayButton, gbc);
        
        // Create "Leaderboard" button
        leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setPreferredSize(new Dimension(150, 50)); // Set size of the button
        leaderboardButton.setForeground(Color.WHITE); // Set text color to white
        leaderboardButton.setBackground(Color.BLACK); // Set button background color for better contrast
        gbc.gridy = 3; // Place below the leaderboardButton
        backgroundPanel.add(leaderboardButton, gbc);

        // Add the background panel (which contains all components) to the frame
        add(backgroundPanel, BorderLayout.CENTER);

        // Add action listeners to the buttons
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Settings().setVisible(true); // Assuming Settings is another JFrame
                dispose(); // Close the MainMenu window
            }
        });

        gameplayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Gameplay().setVisible(true); // Assuming Gameplay is another JFrame
                dispose(); // Close the MainMenu window
            }
        });
        
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Leaderboard().setVisible(true); // Assuming leaderboard is another JFrame
                dispose(); // Close the MainMenu window
            }
        });
    }

    public class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            setLayout(new GridBagLayout()); // Ensure layout is set for adding components
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu example = new MainMenu();
            example.setVisible(true);
        });
    }
}
