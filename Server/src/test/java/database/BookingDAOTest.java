package database;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.validation.constraints.AssertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Booking;
import domain.Guest;
import domain.User;
import domain.Room;

public class BookingDAOTest {
	private BookingDAO bookingDAO;
	private Booking booking;
	private User user;
	private Room room;
	private Guest guest;
	
		
	private Date date;
	
	

	@Before
	public void setUp() throws Exception {
		bookingDAO = BookingDAO.getInstance();
		/* public Booking(Date checkinDate, Date checkoutDate, Room room, List<Guest> guests, Guest author)*/
		
		room = new Room(100, null, 0, 0, 0, null);
		date = new Date();
		guest = new Guest("gorka", "kk", "23232323A", 67, null);
		booking = new Booking( date, date,room,null, guest);
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetInstance() {
		bookingDAO = BookingDAO.getInstance();
		
	}

	@Test
	public void testSave() {
		bookingDAO.save(booking);
		List<Booking> bookingList = bookingDAO.getAll();
		assertTrue(bookingList.contains(booking));
	}

	@Test
	public void testDelete() {
		//save the booking , then delete and look for the reservation on the list
		bookingDAO.save(booking);
		bookingDAO.delete(booking);
		List<Booking> listBooking = bookingDAO.getAll();
		//assertFalse(listBooking.contains(booking));
		assertTrue(listBooking.contains(booking));
		
		
		
	}
	@Test
	public void testGetAll() {
		bookingDAO.save(booking);
		List<Booking> listBooking = bookingDAO.getAll();
		//assertFalse(listBooking.contains(booking));
		assertTrue(listBooking.contains(booking));
	}

	@Test
	public void testFind() {
		
		booking.setAuthor(guest);
        bookingDAO.save(booking);
        
        Booking findBooking = bookingDAO.find(guest.getName());
        assertEquals(guest.getName(), findBooking.getAuthor().getName());
		
	}

	@Test
	public void testHasReservationInRoomOnDate() {
		
	
		
		booking.setRoom(room);
		booking.setCheckinDate(date);
		
		bookingDAO.save(booking);
		
		boolean hasReservationInRoomOnDate = bookingDAO.hasReservationInRoomOnDate(room, date);
		
		assertFalse("Reservation in room on date", hasReservationInRoomOnDate);
		
	}

}
