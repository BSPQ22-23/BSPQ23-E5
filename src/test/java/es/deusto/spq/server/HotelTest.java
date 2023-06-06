package es.deusto.spq.server;

import static org.junit.Assert.*;

import es.deusto.spq.server.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HotelTest {
	private Hotel hotel;

	@Before
	public void setUp() throws Exception {
		hotel = new Hotel("HCR7","Barcelona");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHotelStringStringGuest() {
		String name = "HCR7";
        String location = "Barcelona";
        Hotel hotel = new Hotel(name, location);
       assertEquals(name, hotel.getName());
       assertEquals(location, hotel.getCity());
	}

	@Test
	public void testHotelString() {
		String name = "HCR7";
		 assertEquals(name, hotel.getName());
	}

	


    @Test
    public void testGetName() {
        assertEquals("HCR7", hotel.getName());
    }

    @Test
    public void testSetName() {
        hotel.setName("New Hotel");
        assertEquals("New Hotel", hotel.getName());
    }

    @Test
    public void testGetCity() {
        assertEquals("Barcelona", hotel.getCity());
    }

    @Test
    public void testSetCity() {
        hotel.setCity("Los Angeles");
        assertEquals("Los Angeles", hotel.getCity());
    }




}
