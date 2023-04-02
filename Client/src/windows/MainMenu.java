package windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends JFrame implements ActionListener {
	 	private JLabel welcome, label, info;
	 	private JTextField search;
	    private JButton hotelButton, searchButton, accountButton, contactButton, advSettingsButton, infoButton, searchHotelButton, hotel1Button, hotel2Button, hotel3Button, hotel4Button, hotel5Button, hotel6Button;
	    private JMenuBar menuBar;
	    private JMenu menu, menuH;
	    private JMenuItem mItem, mItem2, mItem3, mItem4;
	    private JPanel buttonPanel, welcomePanel, searchPanel, browserPanel, accountPanel, pCenter;
	    
	    public MainMenu() {
	        super("Menu");
	        
	        welcome = new JLabel("Welcome to the Hotel Management App");
	        label = new  JLabel("Search: ");
	        info = new JLabel("User info such as nickname, stats, recently reserved hotels, etc...");
	        
	        search = new JTextField(20);
	        
	        ImageIcon icon = new ImageIcon("../photos/home.png");
	        ImageIcon icon2 = new ImageIcon("../photos/search.png");
	        ImageIcon icon3 = new ImageIcon("../photos/account.png");
	        ImageIcon icon4 = new ImageIcon("../photos/contact.png");
	        ImageIcon icon5 = new ImageIcon("../photos/settings.png");
	        ImageIcon icon6 = new ImageIcon("../photos/info.png");
	        
	        hotelButton = new JButton(resizeIcon(icon, 60, 60));
	        searchButton = new JButton(resizeIcon(icon2, 60, 60));
	        accountButton = new JButton(resizeIcon(icon3,60, 60));
	        contactButton = new JButton(resizeIcon(icon4, 60, 60));
	        advSettingsButton = new JButton(resizeIcon(icon5, 60, 60));
	        infoButton = new JButton(resizeIcon(icon6, 60, 60));
	        searchHotelButton = new JButton(resizeIcon(icon2, 10, 10));
	        hotel1Button = new JButton("HOTEL 1 INFO");
	        hotel2Button = new JButton("HOTEL 2 INFO");
	        hotel3Button = new JButton("HOTEL 3 INFO");
	        hotel4Button = new JButton("HOTEL 4 INFO");
	        hotel5Button = new JButton("HOTEL 5 INFO");
	        hotel6Button = new JButton("HOTEL 6 INFO");
	        
	        menuBar = new JMenuBar();
	        menu = new JMenu("Account");
	        menuH = new JMenu("Home");
	        mItem = new JMenuItem("Log Out");
	        mItem2 = new JMenuItem("Exit");
	        mItem3 = new JMenuItem("Return Home");
	        mItem4 = new JMenuItem("Exit");
	        
	        hotelButton.addActionListener(this);
	        searchButton.addActionListener(this);
	        accountButton.addActionListener(this);
	        contactButton.addActionListener(this);
	        advSettingsButton.addActionListener(this);
	        infoButton.addActionListener(this);
	        
	        pCenter = new JPanel();
	        pCenter.setBackground(new Color(255, 228, 181));

	        
	        GridLayout gridLayout = new GridLayout(0, 2);
	        gridLayout.setVgap(10);
	        gridLayout.setHgap(40);
	        buttonPanel = new JPanel(gridLayout);
	        buttonPanel.setBackground(new Color(255, 228, 181));
	        buttonPanel.add(hotelButton);
	        buttonPanel.add(searchButton);
	        buttonPanel.add(accountButton);
	        buttonPanel.add(contactButton);
	        buttonPanel.add(advSettingsButton);
	        buttonPanel.add(infoButton);
	        
	        welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        welcomePanel.setBackground(new Color(135, 206, 250));
	        welcomePanel.add(welcome);
	        
	        GridLayout gridLayout2 = new GridLayout(0, 3);
	        gridLayout2.setVgap(25);
	        gridLayout2.setHgap(10);
	        browserPanel = new JPanel(gridLayout2);
	        browserPanel.setBackground(new Color(255, 228, 181));
	        browserPanel.add(hotel1Button);
	        browserPanel.add(hotel2Button);
	        browserPanel.add(hotel3Button);
	        browserPanel.add(hotel4Button);
	        browserPanel.add(hotel5Button);
	        browserPanel.add(hotel6Button);
	        
	        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        searchPanel.setBackground(new Color(135, 206, 250));
	        searchPanel.add(label);
	        searchPanel.add(search);
	        searchPanel.add(searchHotelButton);
	        
	        accountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        accountPanel.setBackground(new Color(135, 206, 250));
	        accountPanel.add(info);
	        
	        pCenter.add(buttonPanel);
	        pCenter.add(accountPanel);
	        pCenter.add(browserPanel);
	        
	        
	        getContentPane().setLayout(new BorderLayout());
	        getContentPane().add(pCenter, BorderLayout.CENTER);
		    accountPanel.setVisible(false);
			browserPanel.setVisible(false);
			getContentPane().add(searchPanel, BorderLayout.NORTH);
		    searchPanel.setVisible(false);
	        getContentPane().add(welcomePanel, BorderLayout.SOUTH);
	        
	        menuH.add(mItem3);
	        menuH.add(mItem4);
	        menu.add(mItem);
	        menu.add(mItem2);
	        menuBar.add(menuH);
	        menuBar.add(menu);
	        setJMenuBar(menuBar);
	        
	        mItem3.addActionListener(this);
	        mItem4.addActionListener(this);
	        
	        setSize(380, 360);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	    }
	    
	    private static Icon resizeIcon(ImageIcon icon, int w, int h) {
	        Image img = icon.getImage();  
	        Image resizedImage = img.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH);  
	        return new ImageIcon(resizedImage);
	    }
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == searchButton) {
				buttonPanel.setVisible(false);
				welcomePanel.setVisible(false);
				searchPanel.setVisible(true);
				browserPanel.setVisible(true);
				browserPanel.revalidate();
				browserPanel.repaint();
				
			 } else if (e.getSource() == accountButton) {
				buttonPanel.setVisible(false);
			    welcomePanel.setVisible(false);
			    accountPanel.setVisible(true);
				
		     } else if (e.getSource() == mItem3) {
		    	 searchPanel.setVisible(false);
				 browserPanel.setVisible(false);
				 accountPanel.setVisible(false);
		    	 welcomePanel.setVisible(true);
		    	 buttonPanel.setVisible(true);
		    	 
		     } else if (e.getSource() == mItem4) {
		    	 this.dispose();
		     }
		}
		
		     public static void main(String[] args) {
		         MainMenu menuW = new MainMenu();
		     }

}