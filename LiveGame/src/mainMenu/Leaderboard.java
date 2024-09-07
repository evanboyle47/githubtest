package mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leaderboard extends JFrame {

	public Leaderboard() {
		//Set up the frame
		setTitle("Leaderboard");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window to full screen
        
        //Create a Panel and a components
        JPanel JPanel1 = new JPanel();
        JPanel1.setLayout(new BorderLayout());
        
        //Create a JLabel
        JLabel label1 = new JLabel("Leaderboard GUI", SwingConstants.CENTER);
        JPanel1.add(label1, BorderLayout.CENTER);
        
        //Create a button to go back to the main menu
        JButton backButton1 = new JButton("Back to Main Menu");
        backButton1.setPreferredSize(new Dimension (200,40));
        backButton1.setBackground(Color.BLACK);
        backButton1.setForeground(Color.WHITE);
        JPanel1.add(backButton1, BorderLayout.SOUTH); // Add the button to the bottom of the panel

        //Add action listener to button
        backButton1.addActionListener(new ActionListener() {
        	 @Override
        	 public void actionPerformed(ActionEvent e) {
        		 new MainMenu().setVisible(true); // Opens main menu
        		 dispose(); //closes the leaderboard window
        	 }
        });
       
        //Add panel to frame
        add(JPanel1);
        
	}
        
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Settings settings = new Settings();
                settings.setVisible(true);
                
	});	
}}
