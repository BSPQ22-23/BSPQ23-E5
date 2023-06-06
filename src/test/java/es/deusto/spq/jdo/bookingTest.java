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
	private int id;
	private Date checkinDate;
	private Date checkoutDate;
	
	private es.deusto.spq.server.Guest author;
	private ArrayList<Guest> guests;

	@Before
	public void setUp() {
		id = 0;
		checkinDate = new Date();
		checkoutDate = new Date();
		
		author = new es.deusto.spq.server.Guest(null, null, "syhj", id, null);
		guests = new ArrayList<Guest>();

		booking = new Booking( checkinDate, checkinDate, null, null, author);
	}

	@Test
	public void testGetId() {
		assertEquals(id, booking.getId());
	}

	@Test
	public void testSetId() {
		int newId = 2;
		booking.setId(newId);
		assertEquals(newId, booking.getId());
	}

	@Test
	public void testGetCheckinDate() {
		assertEquals(checkinDate, booking.getCheckinDate());
	}

	@Test
	public void testSetCheckinDate() {
		Date newCheckinDate = new Date();
		booking.setCheckinDate(newCheckinDate);
		assertEquals(newCheckinDate, booking.getCheckinDate());
	}

	@Test
	public void testGetCheckoutDate() {
		assertEquals(checkoutDate, booking.getCheckoutDate());
	}

	@Test
	public void testSetCheckoutDate() {
		Date newCheckoutDate = new Date();
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
	public void testGetAuthor() {
		assertEquals(author, booking.getAuthor());
	}

	@Test
	public void testSetAuthor() {
		es.deusto.spq.server.Guest newAuthor = new es.deusto.spq.server.Guest("1yu", null, "2567", 24, null);
		booking.setAuthor(newAuthor);
		assertEquals(newAuthor, booking.getAuthor());
	}
	@Test
	public void testAddGuest() {
		
	}

	@Test
	public void testRemoveGuest() {
		
	}

	
	

}
