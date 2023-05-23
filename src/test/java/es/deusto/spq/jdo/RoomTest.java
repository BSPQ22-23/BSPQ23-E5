package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {
	private Room room;
	private int roomNumber;
	private String type;
	private int numMaxGuests;
	private int spaceInMeters;
	private Hotel hotel;
	private float prize;

	@Before
	public void setUp() {
		roomNumber = 101;
		type = "Standard";
		numMaxGuests = 2;
		spaceInMeters = 25;
		prize = 100.0f;
		hotel = new Hotel("Example Hotel", "Example City", new Guest("John", "Doe", "123456789", 30, "Example City"));

		room = new Room(roomNumber, type, numMaxGuests, spaceInMeters, prize, hotel);
	}

	@Test
	public void testGetRoomNumber() {
		assertEquals(roomNumber, room.getRoomNumber());
	}

	@Test
	public void testSetRoomNumber() {
		int newRoomNumber = 102;
		room.setRoomNumber(newRoomNumber);
		assertEquals(newRoomNumber, room.getRoomNumber());
	}

	@Test
	public void testGetType() {
		assertEquals(type, room.getType());
	}

	@Test
	public void testSetType() {
		String newType = "Deluxe";
		room.setType(newType);
		assertEquals(newType, room.getType());
	}

	@Test
	public void testGetNumMaxGuests() {
		assertEquals(numMaxGuests, room.getNumMaxGuests());
	}

	@Test
	public void testSetNumMaxGuests() {
		int newNumMaxGuests = 4;
		room.setNumMaxGuests(newNumMaxGuests);
		assertEquals(newNumMaxGuests, room.getNumMaxGuests());
	}

	@Test
	public void testGetSpaceInMeters() {
		assertEquals(spaceInMeters, room.getSpaceInMeters());
	}

	@Test
	public void testSetSpaceInMeters() {
		int newSpaceInMeters = 30;
		room.setSpaceInMeters(newSpaceInMeters);
		assertEquals(newSpaceInMeters, room.getSpaceInMeters());
	}

	@Test
	public void testGetHotel() {
		assertEquals(hotel, room.getHotel());
	}

	@Test
	public void testSetHotel() {
		Hotel newHotel = new Hotel("New Hotel", "New City", new Guest("Jane", "Smith", "987654321", 35, "New City"));
		room.setHotel(newHotel);
		assertEquals(newHotel, room.getHotel());
	}

	@Test
	public void testGetPrize() {
		assertNotEquals(prize, room.getPrize(), 0.01);
	}

	@Test
	public void testSetPrize() {
		float newPrize = 150.0f;
		room.setPrize(newPrize);
		assertEquals(newPrize, room.getPrize(), 0.01);
	}

	

	@Test
	public void testSetBookings() {
		Booking booking1 = new Booking(3,new Date(0), new Date(0), null, null, null);
		Booking booking2 = new Booking(3,new Date(0), new Date(0), null, null, null);
		List<Booking> bookings = new ArrayList<Booking>();
		bookings.add(booking1);
		bookings.add(booking2);

		room.setBookings(bookings);
		assertEquals(bookings, room.getBookings());
	}

	@Test
	public void testAddBooking() {
		
	}
	
	

}
