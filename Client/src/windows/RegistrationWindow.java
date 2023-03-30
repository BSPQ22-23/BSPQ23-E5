package windows;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationWindow extends JFrame implements ActionListener {


    JLabel nameLabel, lastNameLabel, idLabel, ageLabel, cityLabel, nicknameLabel, passwordLabel;
    JTextField nameTextField, lastNameTextField, idTextField, ageTextField, cityTextField, nicknameTextField, passwordTextField;
    JButton submitButton, clearButton;

    public RegistrationWindow() {
        super("Hotel Registration Form");

        // create labels
        nameLabel = new JLabel("Name:");
        lastNameLabel = new JLabel("Last Name:");
        idLabel = new JLabel("ID Number:");
        ageLabel = new JLabel("Age:");
        cityLabel = new JLabel("City of Origin:");
        nicknameLabel = new JLabel("Nickname:");
        passwordLabel = new JLabel("Password:");

        // create text fields
        nameTextField = new JTextField(20);
        lastNameTextField = new JTextField(20);
        idTextField = new JTextField(20);
        ageTextField = new JTextField(20);
        cityTextField = new JTextField(20);
        nicknameTextField = new JTextField(20);
        passwordTextField = new JPasswordField(20);

        // create buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        // add action listeners to the buttons
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        // create form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 2, 5, 5));
        formPanel.add(nameLabel);
        formPanel.add(nameTextField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameTextField);
        formPanel.add(idLabel);
        formPanel.add(idTextField);
        formPanel.add(ageLabel);
        formPanel.add(ageTextField);
        formPanel.add(cityLabel);
        formPanel.add(cityTextField);
        formPanel.add(nicknameLabel);
        formPanel.add(nicknameTextField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordTextField);

        // create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // add panels to the frame
        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // set frame properties
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameTextField.getText();
            String lastName = lastNameTextField.getText();
            String id = idTextField.getText();
            String age = ageTextField.getText();
            String city = cityTextField.getText();
            String nickname = nicknameTextField.getText();
            String password = passwordTextField.getText();
            JOptionPane.showMessageDialog(this, "Thank you for registering, " + name + "!\n" +
                    "Your nickname is " + nickname + " and your password is " + password);
        } else if (e.getSource() == clearButton) {
            nameTextField.setText("");
            lastNameTextField.setText("");
            idTextField.setText("");
            ageTextField.setText("");
            cityTextField.setText("");
            nicknameTextField.setText("");
            passwordTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new RegistrationWindow();
    }
}
