package es.deusto.spq.util;

import javax.swing.*;
import javax.ws.rs.client.ClientBuilder;

import es.deusto.spq.client.ClientController;
import es.deusto.spq.server.*;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import es.deusto.spq.client.ClientController; // conexion con cliente
//import main.Server;  -> abrir el servidor
/**
 * registration window
 * @author maitane
 *
 */
public class RegistrationWindow extends JFrame implements ActionListener {
	private JLabel nicknameLabel, passwordLabel, nameLabel, lastNameLabel, idLabel, ageLabel, cityLabel;
	private JTextField nicknameTextField, passwordTextField, nameTextField, lastNameTextField, idTextField,
			ageTextField, cityTextField;
	private JButton submitButton, clearButton;
	// ---------------------------
	private ClientController controller;
	private Client client;
	private WebTarget webTarget;

	public RegistrationWindow(ClientController controller) {

		super("Hotel Registration Form");
		
		

	  this.controller = controller;

		nicknameLabel = new JLabel("Nickname:");
		passwordLabel = new JLabel("Password:");
		nameLabel = new JLabel("Name:");
		lastNameLabel = new JLabel("Last Name:");
		idLabel = new JLabel("ID Number:");
		ageLabel = new JLabel("Age:");
		cityLabel = new JLabel("City of Origin:");

		nicknameTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
		nameTextField = new JTextField(20);
		lastNameTextField = new JTextField(20);
		idTextField = new JTextField(20);
		ageTextField = new JTextField(20);
		cityTextField = new JTextField(20);

		submitButton = new JButton("Submit");
		clearButton = new JButton("Clear");

		submitButton.addActionListener(this);
		clearButton.addActionListener(this);

		JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
		formPanel.setBackground(new Color(255, 228, 181));
		formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		formPanel.add(nicknameLabel);
		formPanel.add(nicknameTextField);
		formPanel.add(passwordLabel);
		formPanel.add(passwordTextField);
		formPanel.add(nameLabel);
		formPanel.add(nameTextField);
		formPanel.add(lastNameLabel);
		formPanel.add(lastNameTextField);
	

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(new Color(135, 206, 250));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPanel.add(submitButton);
		buttonPanel.add(clearButton);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(formPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			String nickname = nicknameTextField.getText();
			String lastName = lastNameTextField.getText();
			String password = passwordTextField.getText();
			String name = nameTextField.getText();
			
			
			JOptionPane.showMessageDialog(this, "Thank you for registering, " + name + "!\n" + "Your nickname is "
					+ nickname + " and your password is " + password);

			

			controller.register(nickname, lastName,password);
			new MainMenuClient(controller);
		} else if (e.getSource() == clearButton) {
			nicknameTextField.setText("");
			passwordTextField.setText("");
			nameTextField.setText("");
			lastNameTextField.setText("");
			
		}
	}

	

	public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];
		ClientController controller = new ClientController(hostname, port);
		new RegistrationWindow(controller);
	}

}
