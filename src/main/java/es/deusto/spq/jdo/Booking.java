package es.deusto.spq.jdo;





import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;


import es.deusto.spq.server.Guest;


import javax.jdo.annotations.PersistenceCapable;



/**
 * The Booking class represents a booking made by a guest.
 */
@PersistenceCapable(detachable = "true")
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;
	@Persistent(defaultFetchGroup = "true")
	private int id;
	private Date checkinDate;
	private Date checkoutDate;
	@Persistent(defaultFetchGroup = "true")
	private Room room;
	@Persistent(defaultFetchGroup = "true")
	private Guest author;

	@Persistent(defaultFetchGroup = "true", dependentElement = "true")
	@Join
	private List<Guest> guests;

	/**
	 * Creates a new instance of Booking.
	 * 
	 * @param id           the booking ID
	 * @param checkinDate  the check-in date
	 * @param checkoutDate the check-out date
	 * @param room         the room for the booking
	 * @param guests       the list of guests for the booking
	 * @param author       the author of the booking
	 */
	public Booking(Date checkinDate, Date checkoutDate, Room room, List<Guest> guests, Guest author) {
	
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.room = room;
		this.guests = guests;
		this.author = author;
	}

	/**
	 * Returns the booking ID.
	 * 
	 * @return the booking ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the booking ID.
	 * 
	 * @param id the booking ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the check-in date.
	 * 
	 * @return the check-in date
	 */
	public Date getCheckinDate() {
		return checkinDate;
	}

	/**
	 * Sets the check-in date.
	 * 
	 * @param checkinDate the check-in date to set
	 */
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	/**
	 * Returns the check-out date.
	 * 
	 * @return the check-out date
	 */
	public Date getCheckoutDate() {
		return checkoutDate;
	}

	/**
	 * Sets the check-out date.
	 * 
	 * @param checkoutDate the check-out date to set
	 */
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	/**
	 * Returns the room for the booking.
	 * 
	 * @return the room for the booking
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the room for the booking.
	 * 
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Returns the list of guests for the booking.
	 * 
	 * @return the list of guests for the booking
	 */
	public List<Guest> getGuests() {
		return guests;
	}

	/**
	 * Sets the list of guests for the booking.
	 * 
	 * @param guests the list of guests to set
	 */
	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	/**
	 * Returns the author of the booking.
	 * 
	 * @return the author of the booking
	 */
	public Guest getAuthor() {
		return author;
	}

	/**
	 * Sets the author of the booking.
	 * 
	 * @param author the author to set
	 */
	public void setAuthor(Guest author) {
		this.author = author;
	}

	/**
	 * Adds a guest to the list of guests for the booking.
	 * 
	 * @param guest the guest to add
	 */
	public void addGuest(Guest guest) {
		guests.add(guest);
	}

	/**
	 * Removes a guest from the list of guests for the booking.
	 * 
	 * @param guest the guest to remove
	 */
	public void removeGuest(Guest guest) {
		guests.remove(guest);
	}
}