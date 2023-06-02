package es.deusto.spq.server;

import java.util.Calendar;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;






/**
 * Represents a booking made by a guest for a room.
 */
public class Booking {
    private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private Room room;
    private Guest author;
    private List<Guest> guests;

    /**
     * Constructs a new Booking object with the specified parameters.
     *
     * @param checkinDate  The check-in date for the booking.
     * @param checkoutDate The check-out date for the booking.
     * @param room         The room reserved for the booking.
     * @param guests       The list of guests included in the booking.
     * @param author       The guest who made the booking.
     */
    public Booking(Date checkinDate, Date checkoutDate, Room room, List<Guest> guests, Guest author) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.room = room;
        this.guests = guests;
        this.author = author;
    }

    /**
     * Returns the ID of the booking.
     *
     * @return The ID of the booking.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the booking.
     *
     * @param id The ID of the booking.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the check-in date of the booking.
     *
     * @return The check-in date of the booking.
     */
    public Date getCheckinDate() {
        return checkinDate;
    }

    /**
     * Sets the check-in date of the booking.
     *
     * @param checkinDate The check-in date of the booking.
     */
    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    /**
     * Returns the check-out date of the booking.
     *
     * @return The check-out date of the booking.
     */
    public Date getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * Sets the check-out date of the booking.
     *
     * @param checkoutDate The check-out date of the booking.
     */
    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    /**
     * Returns the room reserved for the booking.
     *
     * @return The room reserved for the booking.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets the room reserved for the booking.
     *
     * @param room The room reserved for the booking.
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Returns the list of guests included in the booking.
     *
     * @return The list of guests included in the booking.
     */
    public List<Guest> getGuests() {
        return guests;
    }

    /**
     * Sets the list of guests included in the booking.
     *
     * @param guests The list of guests included in the booking.
     */
    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    /**
     * Sets the author (guest) who made the booking.
     *
     * @param author The author (guest) who made the booking.
     */
    public void setAuthor(Guest author) {
        this.author = author;
    }

    /**
     * Returns the author (guest) who made the booking.
     *
     * @return The author (guest) who made the booking.
     */
    public Guest getAuthor() {
        return author;
    }

    /**
     * Adds a guest to the booking.
     *
     * @param guest The guest to be added.
     */
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    /**
     * Removes a guest from the booking.
     *
     * @param guest The guest to be removed.
     */
    public void removeGuest(Guest guest) {
        guests.remove(guest);
    }
}