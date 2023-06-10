package es.deusto.spq.util;

import java.awt.BorderLayout;

import java.awt.Component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;


import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextField;


import es.deusto.spq.client.ClientController;
import es.deusto.spq.jdo.Booking;

import es.deusto.spq.server.dao.BookingDAO;



import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



/**
 * Reservation window
 * 
 * @author BSILV
 *
 */
public class ReservationWindow extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel panelArriba, panelCentro, panelCentroCentro, panelCentroAbajo, panelCC1, panelCC4, panelCA1;
	private JLabel lblName, lblNumber, lblCheckin, lblCheckout, lblRoom;

	private JTextField txtname, txtcheckin, txtcheckout, txtroom;
	private JRadioButton rdbtn1, rdbtn2, rdbtn3;

	private JButton btnAceptar;
	private JTextArea area;
	private ClientController cont;
	private JPanel panelArea;

	public ReservationWindow(ClientController controller) {
		cont = controller;
		setLayout(new BorderLayout(0, 0));

		panelArriba = new JPanel();
		add(panelArriba, BorderLayout.NORTH);

		setSize(1000, 800);
		Component lblAniadirReserva = new JLabel(" RESERVATION");
		panelArriba.add(lblAniadirReserva);

		panelCentro = new JPanel();
		add(panelCentro, BorderLayout.WEST);
		panelCentro.setLayout(new GridLayout(2, 1, 0, 0));
		panelCentroCentro = new JPanel();
		panelCentro.add(panelCentroCentro);
		panelCentroCentro.setLayout(new GridLayout(0, 4, 0, 0));

		panelCC1 = new JPanel();
		panelCentroCentro.add(panelCC1);
		panelCC1.setLayout(new GridLayout(0, 1, 0, 0));

		lblName = new JLabel("Guest Name");
		panelCC1.add(lblName);

		txtname = new JTextField();
		panelCC1.add(txtname);
		txtname.setColumns(10);

		lblCheckin = new JLabel("Check-in");
		panelCC1.add(lblCheckin);

		txtcheckin = new JTextField();
		txtcheckin.setText("");
		panelCC1.add(txtcheckin);
		txtcheckin.setColumns(10);

		lblCheckout = new JLabel("Check-out");
		panelCC1.add(lblCheckout);

		txtcheckout = new JTextField();
		panelCC1.add(txtcheckout);
		txtcheckout.setColumns(10);
		panelCA1 = new JPanel();
		panelCentroCentro.add(panelCA1);
		panelCA1.setLayout(new GridLayout(0, 1, 0, 0));

		panelCC4 = new JPanel();
		panelCentroCentro.add(panelCC4);

		btnAceptar = new JButton("Aceptar");
		panelCC4.add(btnAceptar);

		JButton btnVisualizar = new JButton("Visualizar Reserva");
		panelCC4.add(btnVisualizar);

		panelCentroAbajo = new JPanel();
		panelCentro.add(panelCentroAbajo);
		panelCentroAbajo.setLayout(new GridLayout(0, 4, 0, 0));

		lblRoom = new JLabel("Room");
		panelCA1.add(lblRoom);

		txtroom = new JTextField();
		panelCA1.add(txtroom);
		txtroom.setColumns(10);

		lblNumber = new JLabel("Type of room");
		panelCA1.add(lblNumber);

		rdbtn1 = new JRadioButton("Double");
		panelCA1.add(rdbtn1);

		rdbtn2 = new JRadioButton("Single");
		panelCA1.add(rdbtn2);

		rdbtn3 = new JRadioButton("Triple");
		panelCA1.add(rdbtn3);

		panelArea = new JPanel();
		panelCentroCentro.add(panelArea);
		panelArea.setVisible(false);

		btnVisualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				area = new JTextArea();
				panelArea.add(new JScrollPane(area), BorderLayout.CENTER);
				panelArea.setVisible(true);
				area.setEditable(false);
				BookingDAO bookingdao = BookingDAO.getInstance();
				List<Booking> bookings = bookingdao.getAll();

				for (Booking b : bookings) {
					String rowData = "Name: " + b.getGuest_name() + "\n" 
							+ "Check-in: " + b.getCheckinDate() + "\n" 
							+ "Check-out: "+ b.getCheckoutDate() + "\n" 
							+ "Room: " + b.getRoom() + "\n" 
							+ "Type: "+ b.getType()+ "\n\n";

					area.append(rowData);
				}
			}
		});

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "";

				if (rdbtn1.isSelected()) {
					type = rdbtn1.getText();
				} else if (rdbtn2.isSelected()) {
					type = rdbtn2.getText();
				} else if (rdbtn3.isSelected()) {
					type = rdbtn3.getText();
				}

				if (cont != null) {
					cont.createReservation(txtname.getText(), txtcheckin.getText(), txtcheckout.getText(), txtroom.getText(), type);
				} else {
					System.err.println("Error: controller is null");
				}
			}
		});
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Debe proporcionar el hostname y el puerto como argumentos.");
			return;
		}

		String hostname = args[0];
		String port = args[1];
		ClientController controller = new ClientController(hostname, port);
		new ReservationWindow(controller);
		System.out.println(String.format("IP: %s y Puerto: %s que entra en la ventana reservation", hostname, port));
	}
}