package windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame{
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckbox;

    public LoginWindow() {
        super("Login");

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');

        showPasswordCheckbox = new JCheckBox("Show password");
        showPasswordCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);


                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                /*
                if(loginResult == "client") {
                	MainMenuClient menuW = new MainMenuClient();
                	this.dispose();
                } else if (loginResult == "owner") {
                	MainMenuOwner menuOw = new MainMenuOwner();
                	this.dispose();
                } else {
                	System.out.println("Login failed");
                }
                */
            }
        });

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(showPasswordCheckbox);
        panel.add(loginButton);

        this.add(panel);

        this.setSize(300, 200);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
