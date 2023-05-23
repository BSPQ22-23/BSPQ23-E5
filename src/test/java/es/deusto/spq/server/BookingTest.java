package es.deusto.spq.server;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.*;

public class BookingTest {
	 private Booking booking;
	    private Room room;
	    private List<Guest> guests;
	    private Guest author;

	    @Before
	    public void setUp() {
	        room = new Room(101, "Standard", 2, 25, 100.0f, new Hotel("Hotel XYZ", "City A", new Guest("John", "Doe", "123456789", 30, "City B")));
	        guests = new ArrayList<>();
	        guests.add(new Guest("Jane", "Smith", "987654321", 28, "City C"));
	        guests.add(new Guest("Bob", "Johnson", "456789123", 35, "City D"));
	        author = new Guest("Michael", "Williams", "654321987", 32, "City E");

	        Date checkinDate = new Date();
	        Date checkoutDate = new Date();
	        booking = new Booking(checkinDate, checkoutDate, room, guests, author);
	    }

	    @Test
	    public void testGetId() {
	        assertEquals(0, booking.getId());
	    }

	    @Test
	    public void testSetId() {
	        booking.setId(1);
	        assertEquals(1, booking.getId());
	    }

	    @Test
	    public void testGetCheckinDate() {
	        assertNotNull(booking.getCheckinDate());
	    }

	    @Test
	    public void testSetCheckinDate() {
	        Date newCheckinDate = new Date();
	        booking.setCheckinDate(newCheckinDate);
	        assertEquals(newCheckinDate, booking.getCheckinDate());
	    }

	    @Test
	    public void testGetCheckoutDate() {
	        assertNotNull(booking.getCheckoutDate());
	    }

	    @Test
	    public void testSetCheckoutDate() {
	        Date newCheckoutDate = new Date();
	        booking.setCheckoutDate(newCheckoutDate);
	        assertEquals(newCheckoutDate, booking.getCheckoutDate());
	    }

	    @Test
	    public void testGetRoom() {
	        assertEquals(room, booking.getRoom());
	    }

	    @Test
	    public void testSetRoom() {
	        Room newRoom = new Room(102, "Deluxe", 4, 40, 200.0f, new Hotel("Hotel ABC", "City X", new Guest("David", "Brown", "789456123", 45, "City Y")));
	        booking.setRoom(newRoom);
	        assertEquals(newRoom, booking.getRoom());
	    }

	    @Test
	    public void testGetGuests() {
	        assertEquals(guests, booking.getGuests());
	    }

	    @Test
	    public void testSetGuests() {
	        List<Guest> newGuests = new ArrayList<>();
	        newGuests.add(new Guest("Sarah", "Johnson", "321654987", 31, "City Z"));
	        booking.setGuests(newGuests);
	        assertEquals(newGuests, booking.getGuests());
	    }

	    @Test
	    public void testGetAuthor() {
	        assertEquals(author, booking.getAuthor());
	    }

	    @Test
	    public void testSetAuthor() {
	        Guest newAuthor = new Guest("Emily", "Davis", "741852963", 27, "City W");
	        booking.setAuthor(newAuthor);
	        assertEquals(newAuthor, booking.getAuthor());
	    }

	    @Test
	    public void testAddGuest() {
	        Guest newGuest = new Guest("Alex", "Taylor", "258963147", 29, "City V");
	        booking.addGuest(newGuest);
	        assertTrue(booking.getGuests().contains(newGuest));
	    }

	    @Test
	    public void testRemoveGuest() {
	        Guest guestToRemove = guests.get(0);
	        booking.removeGuest(guestToRemove);
	        assertFalse(booking.getGuests().contains(guestToRemove));
	    }
}