package es.deusto.spq.server.domain;

import java.util.Calendar;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a booking in the hotel management system.
 */
public class Booking {
    private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private Room room;
    private Guest author;
    private List<Guest> guests;

    /**
     * Constructs a Booking object with the specified details.
     *
     * @param checkinDate   The check-in date of the booking.
     * @param checkoutDate  The check-out date of the booking.
     * @param room          The room reserved for the booking.
     * @param guests        The list of guests associated with the booking.
     * @param author        The guest who made the booking.
     */
    public Booking(Date checkinDate, Date checkoutDate, Room room, List<Guest> guests, Guest author) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.room = room;
        this.guests = guests;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    /**
     * Sets the author (guest) of the booking.
     *
     * @param author The guest who made the booking.
     */
    public void setAuthor(Guest author) {
        this.author = author;
    }

    /**
     * Retrieves the author (guest) of the booking.
     *
     * @return The guest who made the booking.
     */
    public Guest getAuthor() {
        return author;
    }

    /**
     * Adds a guest to the booking.
     *
     * @param guest The guest to add.
     */
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    /**
     * Removes a guest from the booking.
     *
     * @param guest The guest to remove.
     */
    public void removeGuest(Guest guest) {
        guests.remove(guest);
    }
}
