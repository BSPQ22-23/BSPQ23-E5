package es.deusto.spq.util;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

import es.deusto.spq.client.ClientController;

public class MainMenuClient extends JFrame {
	public MainMenuClient() {
		
		JPanel panelInfo = new JPanel();
		getContentPane().add(panelInfo, BorderLayout.NORTH);
		panelInfo.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblInfo = new JLabel("WELCOME TO THE MENU");
		lblInfo.setBackground(Color.BLUE);
		lblInfo.setForeground(new Color(0, 0, 0));
		panelInfo.add(lblInfo);
		
		JPanel panelBotton = new JPanel();
		getContentPane().add(panelBotton, BorderLayout.WEST);
		panelBotton.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCreateReservation = new JButton("New Reservation");
		panelBotton.add(btnCreateReservation);
		
		JButton btnGetHotels = new JButton("Info Hotel");
		panelBotton.add(btnGetHotels);
		
		JButton btnGetReservations = new JButton("Info Reservation");
		panelBotton.add(btnGetReservations);
		
		JButton btnExit = new JButton("Exit");
		panelBotton.add(btnExit);
	}
	   
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
		
		     public static void main(String[] args) {
		         MainMenuClient menuW = new MainMenuClient();
		     }

			

}
