package es.deusto.spq.server;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.*;

public class RoomTest {
	private Room room;
    private Hotel hotel;
    private Booking booking1;
    private Booking booking2;

    @Before
    public void setUp() {
        hotel = new Hotel("Sample Hotel", "New York", new Guest("John", "Doe", "123456789", 30, "New York"));
        room = new Room(101, "Single", 1, 20, 100.0f, hotel);
        booking1 = new Booking(new Date(0), new Date(0), room, new ArrayList<>(), new Guest("Jane", "Smith", "987654321", 25, "Los Angeles"));
        booking2 = new Booking(new Date(0), new Date(0), room, new ArrayList<>(), new Guest("Alice", "Johnson", "555555555", 35, "San Francisco"));

        List<Booking> bookings = new ArrayList<Booking>();
        bookings.add(booking1);
        bookings.add(booking2);
        room.setBookings(bookings);
    }

    @Test
    public void testGetRoomNumber() {
        assertEquals(101, room.getRoomNumber());
    }

    @Test
    public void testSetRoomNumber() {
        room.setRoomNumber(201);
        assertEquals(201, room.getRoomNumber());
    }

    @Test
    public void testGetType() {
        assertEquals("Single", room.getType());
    }

    @Test
    public void testSetType() {
        room.setType("Double");
        assertEquals("Double", room.getType());
    }

    @Test
    public void testGetNumMaxGuests() {
        assertEquals(1, room.getNumMaxGuests());
    }

    @Test
    public void testSetNumMaxGuests() {
        room.setNumMaxGuests(2);
        assertEquals(2, room.getNumMaxGuests());
    }

    @Test
    public void testGetSpaceInMeters() {
        assertEquals(20, room.getSpaceInMeters());
    }

    @Test
    public void testSetSpaceInMeters() {
        room.setSpaceInMeters(30);
        assertEquals(30, room.getSpaceInMeters());
    }

    @Test
    public void testGetHotel() {
        assertEquals(hotel, room.getHotel());
    }

    @Test
    public void testSetHotel() {
        Hotel newHotel = new Hotel("New Hotel", "Los Angeles", new Guest("Robert", "Johnson", "123123123", 40, "Chicago"));
        room.setHotel(newHotel);
        assertEquals(newHotel, room.getHotel());
    }



    @Test
    public void testSetPrize() {
        room.setPrize(120.0f);
        assertEquals(120.0f, room.getPrize(), 0.01);
    }

    @Test
    public void testGetBookings() {
        List<Booking> expectedBookings = new ArrayList<>();
        expectedBookings.add(booking1);
        expectedBookings.add(booking2);
        assertEquals(expectedBookings, room.getBookings());
    }

    @Test
    public void testSetBookings() {
        List<Booking> newBookings = new ArrayList<>();
        newBookings.add(new Booking(new Date(0), new Date(0), room, new ArrayList<>(), new Guest("Michael", "Brown", "111111111", 45, "Seattle")));
        room.setBookings(newBookings);
        assertEquals(newBookings, room.getBookings());
    }

    @Test
    public void testAddBooking() {
        Booking booking3 = new Booking(new Date(0), new Date(0), room, new ArrayList<>(), new Guest("Sarah", "Davis", "222222222", 28, "Boston"));
        room.addBooking(booking3);

        List<Booking> expectedBookings = new ArrayList<>();
        expectedBookings.add(booking1);
        expectedBookings.add(booking2);
        expectedBookings.add(booking3);

        assertEquals(expectedBookings, room.getBookings());
    }

}
