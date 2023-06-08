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
	   
	    private List<Guest> guests;
	    private String author;
	    private String type;
	    private String room;

	    @Before
	    public void setUp() {
	       
	        guests = new ArrayList<>();
	        guests.add(new Guest("Jane", "Smith", "987654321", 28, "City C"));
	        guests.add(new Guest("Bob", "Johnson", "456789123", 35, "City D"));
	        author = "maitane";
	        type = "single";
	        room = "234A";

	        Date checkinDate = new Date();
	        Date checkoutDate = new Date();
	      //  public Booking(Date checkinDate, Date checkoutDate, String room, String guest_name ,String type) 
	        booking = new Booking( checkinDate, checkoutDate,room, author,type);
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