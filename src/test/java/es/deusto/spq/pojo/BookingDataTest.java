package es.deusto.spq.pojo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookingDataTest {
private static BookingData bookingdata ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookingdata = new BookingData();
		bookingdata.setGuest_name("Juan");
		bookingdata.setCheckinDate("29-06-2023");
		bookingdata.setCheckoutDate("03-06-2023");
		bookingdata.setRoom("room2");
		bookingdata.setType("Double");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetRoom() {
		assertEquals("room2",bookingdata.getRoom());
	}

	@Test
	public void testSetRoom() {
		
	}

	@Test
	public void testGetGuest_name() {
		assertEquals("Juan",bookingdata.getGuest_name());	
		}

	@Test
	public void testSetGuest_name() {
		
	}

	@Test
	public void testGetType() {
		assertEquals("Double",bookingdata.getType());
	}

	@Test
	public void testSetType() {
		
	}

	@Test
	public void testGetCheckinDate() {
		assertEquals("29-06-2023",bookingdata.getCheckinDate());
	}

	@Test
	public void testSetCheckinDate() {
		
	}

	@Test
	public void testGetCheckoutDate() {
		assertEquals("03-06-2023",bookingdata.getCheckoutDate());
	}

	@Test
	public void testSetCheckoutDate() {
		
	}

}
