package es.deusto.spq.jdo;

import static org.junit.Assert.*;


import java.util.ArrayList;



import org.junit.Before;
import org.junit.Test;


public class HotelTest {

	
	private Hotel hotel;
	private String name;
	private String city;
	

	@Before
	public void setUp() {
		
		name = "Example Hotel";
		city = "Example City";
		

		hotel = new Hotel(name, city);
	}

	@Test
	public void testGetName() {
		assertEquals(name, hotel.getName());
	}

	@Test 
	public void testHotel() {
		
		
	}
	@Test
	public void testSetName() {
		String newName = "New Hotel Name";
		hotel.setName(newName);
		assertEquals(newName, hotel.getName());
	}

	@Test
	public void testGetCity() {
		assertEquals(city, hotel.getCity());
	}

	@Test
	public void testSetCity() {
		String newCity = "New City";
		hotel.setCity(newCity);
		assertEquals(newCity, hotel.getCity());
	}

	
	}
