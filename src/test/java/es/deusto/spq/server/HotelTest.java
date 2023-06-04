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
