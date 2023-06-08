package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.datanucleus.store.types.wrappers.List;

import es.deusto.spq.jdo.*;

import org.junit.Before;
import org.junit.Test;

public class bookingTest {

	private Booking booking;
	
	private String checkinDate;
	private String checkoutDate;
	private String guest_name;
	private String type;
	private String room;
	
	private es.deusto.spq.server.Guest author;
	private ArrayList<Guest> guests;

	@Before
	public void setUp() {
		
		checkinDate = "08-06-2023";
		checkoutDate ="18-06-2023";
		room = "234A";
		guest_name = "maitane";
		type= "single";
		
		
		
		guests = new ArrayList<Guest>();

		booking = new Booking(checkinDate,checkoutDate,room,guest_name,type);
	}

	
	@Test
	public void testGetCheckinDate() {
		assertEquals(checkinDate, booking.getCheckinDate());
	}

	@Test
	public void testSetCheckinDate() {
		String newCheckinDate = "21-06-2023";
		booking.setCheckinDate(newCheckinDate);
		assertEquals(newCheckinDate, booking.getCheckinDate());
	}

	@Test
	public void testGetCheckoutDate() {
		assertEquals(checkoutDate, booking.getCheckoutDate());
	}

	@Test
	public void testSetCheckoutDate() {
		String newCheckoutDate = "30-06-2023";
		booking.setCheckoutDate(newCheckoutDate);
		assertEquals(newCheckoutDate, booking.getCheckoutDate());
	}

	


	@Test
	public void testGetGuests() {
		assertNotEquals(guests, booking.getGuests());
	}

	@Test
	public void testSetGuests() {
		java.util.List<es.deusto.spq.server.Guest> newGuests = new ArrayList<es.deusto.spq.server.Guest>();
		booking.setGuests(newGuests);
		assertEquals(newGuests, booking.getGuests());
	}

	
	@Test
	public void testAddGuest() {
		
	}

	@Test
	public void testRemoveGuest() {
		
	}

	
	

}
