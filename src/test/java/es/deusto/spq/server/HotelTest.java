package es.deusto.spq.server;

import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class HotelTest {
	private Hotel hotel;
    private Guest owner;
    private Room room1;
    private Room room2;
    private Service service1;
    private Service service2;

    @Before
    public void setUp() {
        owner = new Guest("John", "Doe", "123456789", 30, "New York");
        room1 = new Room(101, "Single", 1, 0, 0, hotel);
        room2 = new Room(202, "Double", 2, 0, 0, hotel);
        service1 = new Service("WiFi", null, 10.0);
        service2 = new Service("Breakfast", null, 20.0);

        hotel = new Hotel("Sample Hotel", "New York", owner);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addService(service1);
        hotel.addService(service2);
    }

    @Test
    public void testGetName() {
        assertEquals("Sample Hotel", hotel.getName());
    }

    @Test
    public void testSetName() {
        hotel.setName("New Hotel");
        assertEquals("New Hotel", hotel.getName());
    }

    @Test
    public void testGetCity() {
        assertEquals("New York", hotel.getCity());
    }

    @Test
    public void testSetCity() {
        hotel.setCity("Los Angeles");
        assertEquals("Los Angeles", hotel.getCity());
    }

    @Test
    public void testGetRooms() {
        List<Room> expectedRooms = new ArrayList<Room>();
        expectedRooms.add(room1);
        expectedRooms.add(room2);
        assertEquals(expectedRooms, hotel.getRooms());
    }

    @Test
    public void testSetRooms() {
        List<Room> newRooms = new ArrayList<>();
        newRooms.add(new Room(301, "Single", 1, 0, 0, hotel));
        newRooms.add(new Room(402, "Double", 2, 0, 0, hotel));

        hotel.setRooms(newRooms);
        assertEquals(newRooms, hotel.getRooms());
    }

    @Test
    public void testAddRoom() {
        Room room3 = new Room(301, "Single", 1, 0, 0, hotel);
        hotel.addRoom(room3);

        List<Room> expectedRooms = new ArrayList<>();
        expectedRooms.add(room1);
        expectedRooms.add(room2);
        expectedRooms.add(room3);

        assertEquals(expectedRooms, hotel.getRooms());
    }

    @Test
    public void testRemoveRoom() {
        hotel.removeRoom(room1);

        List<Room> expectedRooms = new ArrayList<>();
        expectedRooms.add(room2);

        assertEquals(expectedRooms, hotel.getRooms());
    }

    @Test
    public void testGetServices() {
        List<Service> expectedServices = new ArrayList<>();
        expectedServices.add(service1);
        expectedServices.add(service2);
        assertEquals(expectedServices, hotel.getServices());
    }

    @Test
    public void testSetServices() {
        List<Service> newServices = new ArrayList<>();
        newServices.add(new Service("Gym Access", null, 15.0));
        newServices.add(new Service("Laundry", null, 25.0));

        hotel.setServices(newServices);
        assertEquals(newServices, hotel.getServices());
    }

    @Test
    public void testAddService() {
        Service service3 = new Service("Parking", null, 10.0);
        hotel.addService(service3);

        List<Service> expectedServices = new ArrayList<>();
        expectedServices.add(service1);
        expectedServices.add(service2);
        expectedServices.add(service3);

        assertEquals(expectedServices, hotel.getServices());
    }

    @Test
    public void testRemoveService() {
        hotel.removeService(service1);

        List<Service> expectedServices = new ArrayList<>();
        expectedServices.add(service2);

        assertEquals(expectedServices, hotel.getServices());
    }

    @Test
    public void testGetOwner() {
        assertEquals(owner, hotel.getOwner());
    }

    @Test
    public void testSetOwner() {
        Guest newOwner = new Guest("Jane", "Smith", "987654321", 25, "Los Angeles");
        hotel.setOwner(newOwner);

        assertEquals(newOwner, hotel.getOwner());
    }

}
