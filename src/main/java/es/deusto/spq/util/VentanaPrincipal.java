package es.deusto.spq.util;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.ClientController;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(ClientController controller) {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLog = new JPanel();
		contentPane.add(panelLog, BorderLayout.WEST);
		panelLog.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel usernameLabel = new JLabel("Username:");
		panelLog.add(usernameLabel);
		
		textField = new JTextField(20);
		panelLog.add(textField);
		
		JLabel passwordLabel = new JLabel("Password:");
		panelLog.add(passwordLabel);
		
		passwordField = new JPasswordField(20);
		passwordField.setEchoChar('*');
		panelLog.add(passwordField);
		
		JCheckBox showPasswordCheckbox = new JCheckBox("Show password");
		panelLog.add(showPasswordCheckbox);
		
		JButton loginButton = new JButton("Login");
		panelLog.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				controller.login(usernameLabel.getText(),passwordField.getText());
				
			}
		});
		
		JPanel panelRegister = new JPanel();
		contentPane.add(panelRegister, BorderLayout.EAST);
		panelRegister.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblDNI = new JLabel("DNI");
		panelRegister.add(lblDNI);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		panelRegister.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel usernameLabel_1 = new JLabel("Username:");
		panelRegister.add(usernameLabel_1);
		
		textField_1 = new JTextField(20);
		panelRegister.add(textField_1);
		
		JLabel lblLastName = new JLabel("LastName");
		panelRegister.add(lblLastName);
		
		textField_2 = new JTextField();
		panelRegister.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel passwordLabel_1 = new JLabel("Password:");
		panelRegister.add(passwordLabel_1);
		
		passwordField_1 = new JPasswordField(20);
		passwordField_1.setEchoChar('*');
		panelRegister.add(passwordField_1);
		
		JLabel lblCity = new JLabel("City");
		panelRegister.add(lblCity);
		
		textField_3 = new JTextField();
		panelRegister.add(textField_3);
		textField_3.setColumns(10);
		
		JButton RegisterButton_1 = new JButton("Register");
		panelRegister.add(RegisterButton_1);
		RegisterButton_1.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.register(textField_1.getText(), textField_2.getText(), passwordField_1.getText());
				
			}
		});
		
		JLabel label = new JLabel("New label");
		contentPane.add(label, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			String hostname = args[0];
			String port = args[1];
			ClientController controller = new ClientController(hostname, port);
			VentanaPrincipal ventana =new VentanaPrincipal(controller);
			ventana.setVisible(true);
	System.out.println(String.format("IP :%s y Puerto :%s que entra en la ventana login", hostname,port));
	}
}
