package windows;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelBrowserWindow extends JFrame {
    private JTextField searchField;
    private JTextArea hotelListArea;
    private JButton viewHotelButton, homeButton,searchButton;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HotelBrowserWindow();
            }
        });
    }

    public HotelBrowserWindow() {
        setTitle("HOTEL BROWSER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 400));

        // Create components
        searchField = new JTextField();
        searchButton = new JButton("Search");
        hotelListArea = new JTextArea();
        viewHotelButton = new JButton("View Hotel");
        homeButton = new JButton("Home");

        // Add action listeners
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText();
                searchHotels(query);
            }
        });

        viewHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement logic to enter the hotel description window
                JOptionPane.showMessageDialog(null, "Entering hotel description window...");
            }
        });

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement logic to return to the home page
                JOptionPane.showMessageDialog(null, "Returning to the home page...");
                dispose();
                MainMenuClient mmc = new MainMenuClient();
                mmc.setVisible(true);
            }
        });

        // Add components to the frame
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        JScrollPane hotelListScrollPane = new JScrollPane(hotelListArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(viewHotelButton);
        buttonPanel.add(homeButton);

        getContentPane().add(searchPanel, BorderLayout.NORTH);
        getContentPane().add(hotelListScrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }



    private void searchHotels(String query) {
        // Configura la conexión a la base de datos (actualiza con tus propias credenciales y detalles de la base de datos)
        String url = "jdbc:mysql://loclhost:3306/HotelManagementDB";
        String username = "localhost";
        String password = "spq";

        try ( Connection connection = DriverManager.getConnection(url, username, password)){
        	String sql = "SELECT hotel FROM hoteles WHERE name LIKE '%" + query + "%'";

            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Procesa los resultados de la consulta
            StringBuilder resultBuilder = new StringBuilder();
            while (resultSet.next()) {
                String hotelName = resultSet.getString("name");
                resultBuilder.append("- ").append(hotelName).append("\n");
            }

            // Cierra la conexión y los recursos relacionados
            resultSet.close();
            statement.close();
            connection.close();

            //update the textarea
            hotelListArea.setText("Search results:\n" + resultBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}