package es.deusto.spq.jdo;

import static org.junit.Assert.*;


import java.util.ArrayList;



import org.junit.Before;
import org.junit.Test;


public class HotelTest {

	
	private Hotel hotel;
	private String name;
	private String city;
	private Guest owner;

	@Before
	public void setUp() {
		
		name = "Example Hotel";
		city = "Example City";
		owner = new Guest("John", "Doe", "123456789", 30, "Example City");

		hotel = new Hotel(name, city, owner);
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

	@Test
	public void testGetRooms() {
		assertEquals(0, hotel.getRooms().size());
	}

	@Test
	public void testSetRooms() {
		Room room1 = new Room(101, "Standard", 2, 25, 100.0f, hotel);
		Room room2 = new Room(102, "Deluxe", 4, 40, 200.0f, hotel);

		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(room1);
		rooms.add(room2);

		hotel.setRooms(rooms);

		assertEquals(2, hotel.getRooms().size());
		assertEquals(room1, hotel.getRooms().get(0));
		assertEquals(room2, hotel.getRooms().get(1));
	}

	@Test
	public void testAddRoom() {
		Room room = new Room(101, "Standard", 2, 25, 100.0f, hotel);
		hotel.addRoom(room);

		assertEquals(1, hotel.getRooms().size());
		assertEquals(room, hotel.getRooms().get(0));
	}

	@Test
	public void testRemoveRoom() {
		Room room = new Room(101, "Standard", 2, 25, 100.0f, hotel);
		hotel.addRoom(room);
		hotel.removeRoom(room);

		assertEquals(0, hotel.getRooms().size());
	}

	@Test
	public void testGetServices() {
		assertEquals(0, hotel.getServices().size());
	}

	@Test
	public void testSetServices() {
		Service service1 = new Service("WiFi", city, 10.0f);
		Service service2 = new Service("Breakfast", city, 15.0f);

		ArrayList<Service> services = new ArrayList<Service>();
		services.add(service1);
		services.add(service2);

		hotel.setServices(services);

		assertEquals(2, hotel.getServices().size());
		assertEquals(service1, hotel.getServices().get(0));
		assertEquals(service2, hotel.getServices().get(1));
	}

	@Test
	public void testAddService() {
		Service service = new Service("WiFi", city, 10.0f);
		hotel.addService(service);

		assertEquals(1, hotel.getServices().size());
		assertEquals(service, hotel.getServices().get(0));
	}

	@Test
	public void testRemoveService() {
		Service service = new Service("WiFi", city, 10.0f);
		hotel.addService(service);
		hotel.removeService(service);

		assertEquals(0, hotel.getServices().size());
	}

	@Test
	public void testGetOwner() {
		assertEquals(owner, hotel.getOwner());
	}

	@Test
	public void testSetOwner() {
		Guest newOwner = new Guest("Jane", "Smith", "987654321", 35, "New City");
		hotel.setOwner(newOwner);

		assertEquals(newOwner, hotel.getOwner());
	}

}
