package es.deusto.spq.util;
import javax.swing.*;



import es.deusto.spq.client.ClientController;
import es.deusto.spq.jdo.Hotel;
import es.deusto.spq.server.dao.HotelDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
/**
 * hOTEL BROWSER WINDOW
 * @author BSILV
 *
 */
public class HotelBrowserWindow extends JFrame  {
    private JTextField searchField;
    private JTextArea hotelListArea;
    private JButton viewHotelButton, homeButton,searchButton;
    
    public  ClientController controller;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new HotelBrowserWindow(ClientController controller);
            	
            }
        });
    }

    public HotelBrowserWindow(ClientController controller) {
        setTitle("HOTEL BROWSER");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 400));
        this.controller = controller;

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
                HotelDAO hotelDAO = HotelDAO.getInstance();
                List<Hotel> hotels = hotelDAO.getbyName(query);
                StringBuilder sb = new StringBuilder();
               
                for (Hotel hotel : hotels) {
                    sb.append("ID: ").append(hotel.getId())
                      .append(", Nombre: ").append(hotel.getName())
                      .append(", Ciudad: ").append(hotel.getCity())
                      .append("\n");
                }
                hotelListArea.setText(sb.toString());
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
                MainMenuClient mmc = new MainMenuClient(controller);
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



   
   
}