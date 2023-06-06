package es.deusto.spq.util;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import es.deusto.spq.client.ClientController;
import java.awt.BorderLayout; // conexion con cliente
//import main.Server;  -> abrir el servidor
/**
 * lOGIN WINDOW 
 * @author BSILV
 *
 */
public class LoginWindow extends JFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JCheckBox showPasswordCheckbox;
	private ClientController cont;

	public LoginWindow(ClientController controller) {
		cont = controller;
		JLabel usernameLabel = new JLabel("Username:");
		usernameField = new JTextField(20);
		JLabel passwordLabel = new JLabel("Password:");
		passwordField = new JPasswordField(20);
		passwordField.setEchoChar('*');
		JButton loginButton = new JButton("Login");
		showPasswordCheckbox = new JCheckBox("Show password");
		JButton rbotton = new JButton("r");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(showPasswordCheckbox);
		panel.add(rbotton);
		panel.add(loginButton);
		getContentPane().add(panel);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		showPasswordCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showPasswordCheckbox.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});

		loginButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.login(usernameField.getText(), passwordField.getText());

			}
		});
		rbotton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegistrationWindow(cont);

			}
		});
	}

	public static void main(String[] args) {

		String hostname = args[0];
		String port = args[1];
		ClientController controller = new ClientController(hostname, port);
		new LoginWindow(controller);
		System.out.println(String.format("IP :%s y Puerto :%s que entra en la ventana login", hostname, port));

	}

}
