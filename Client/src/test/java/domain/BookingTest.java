package domain;

import org.junit.Test;

import domain.Booking;
import domain.Guest;
import domain.Room;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingTest {
    
    @Test
    public void testGetId() {
        Booking booking = new Booking(null, null, null, null, null);
        assertEquals(1, booking.getId());
    }

    @Test
    public void testSetId() {
        Booking booking = new Booking(null, null, null, null, null);
        booking.setId(1);
        assertEquals(1, booking.getId());
    }

    @Test
    public void testGetCheckinDate() {
        Date checkinDate = new Date();
        Booking booking = new Booking(checkinDate, checkinDate, null, null, null);
        assertEquals(checkinDate, booking.getCheckinDate());
    }

    @Test
    public void testSetCheckinDate() {
        Date checkinDate = new Date();
        Booking booking = new Booking(checkinDate, checkinDate, null, null, null);
        booking.setCheckinDate(checkinDate);
        assertEquals(checkinDate, booking.getCheckinDate());
    }

    @Test
    public void testGetCheckoutDate() {
        Date checkoutDate = new Date();
        Booking booking = new Booking(checkoutDate, checkoutDate, null, null, null);
        assertEquals(checkoutDate, booking.getCheckoutDate());
    }

    @Test
    public void testSetCheckoutDate() {
        Date checkoutDate = new Date();
        Booking booking = new Booking(checkoutDate, checkoutDate, null, null, null);
        booking.setCheckoutDate(checkoutDate);
        assertEquals(checkoutDate, booking.getCheckoutDate());
    }

    @Test
    public void testGetRoom() {
        Room room = new Room(0, null, 0, 0, 0, null);
        Booking booking = new Booking(null, null, room, null, null);
        assertEquals(room, booking.getRoom());
    }

    @Test
    public void testSetRoom() {
        Room room = new Room(0, null, 0, 0, 0, null);
        Booking booking = new Booking(null, null, room, null, null);
        booking.setRoom(room);
        assertEquals(room, booking.getRoom());
    }

    @Test
    public void testGetGuests() {
        List<Guest> guests = new ArrayList<>();
        Booking booking = new Booking(null, null, null, guests, null);
        assertEquals(guests, booking.getGuests());
    }

    @Test
    public void testSetGuests() {
        List<Guest> guests = new ArrayList<>();
        Booking booking = new Booking(null, null, null, guests, null);
        booking.setGuests(guests);
        assertEquals(guests, booking.getGuests());
    }

    @Test
    public void testAddGuest() {
        Guest guest = new Guest(null, null, null, 0, null);
        Booking booking = new Booking(null, null, null, null, guest);
        booking.addGuest(guest);
        assertTrue(booking.getGuests().contains(guest));
    }

    @Test
    public void testRemoveGuest() {
        Guest guest = new Guest(null, null, null, 0, null);
        Booking booking = new Booking(null, null, null, null, guest);
        booking.addGuest(guest);
        booking.removeGuest(guest);
        assertFalse(booking.getGuests().contains(guest));
    }
    
}