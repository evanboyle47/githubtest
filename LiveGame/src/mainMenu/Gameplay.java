package mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gameplay extends JFrame {

    public Gameplay() {
        // Set up the frame
        setTitle("Gameplay");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window to full screen

        // Create a panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a JLabel
        JLabel label = new JLabel("Gameplay GUI", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // Create a button to go back to the main menu
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setPreferredSize(new Dimension(200, 40)); // Set size of the button
        backButton.setForeground(Color.WHITE); // Set text color to white
        backButton.setBackground(Color.BLACK); // Set button background color for better contrast
        panel.add(backButton, BorderLayout.SOUTH); // Add the button to the bottom of the panel

        // Add action listener to the button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu().setVisible(true); // Open MainMenu
                dispose(); // Close the Gameplay window
            }
        });

        // Add panel to frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gameplay gameplay = new Gameplay();
            gameplay.setVisible(true);
        });
    }
}
