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

        // Create the username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        // Create the password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');

        // Create the show password checkbox
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

        // Create the login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // TODO: Authenticate the user

                // For now, just print the username and password
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        });

        // Create the panel to hold the components
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(showPasswordCheckbox);
        panel.add(loginButton);

        // Add the panel to the frame
        this.add(panel);

        // Set the size and center the window
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);

        // Show the window
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
