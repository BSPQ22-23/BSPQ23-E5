package es.deusto.spq.jdo;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * The Room class represents a room in a hotel.
 */
@PersistenceCapable(detachable = "true")
public class Room implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
    private int roomNumber;
    private String type;
    private int numMaxGuests;
    private int spaceInMeters;
    @Persistent(defaultFetchGroup = "true")
    private Hotel hotel; 
    private float prize;
    @Persistent(defaultFetchGroup = "true", dependentElement = "true")
    @Join
    private List<Booking> bookings;

    /**
     * Constructs a Room object with the given parameters.
     * 
     * @param roomNumber    the room number
     * @param type          the room type
     * @param numMaxGuests  the maximum number of guests allowed in the room
     * @param spaceInMeters the space in meters of the room
     * @param prize         the prize of the room
     * @param hotel         the hotel to which the room belongs
     */
    public Room(int roomNumber, String type, int numMaxGuests, int spaceInMeters, float prize, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.numMaxGuests = numMaxGuests;
        this.spaceInMeters = spaceInMeters;
        this.hotel = hotel;
    }

    /**
     * Returns the room number.
     * 
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number.
     * 
     * @param roomNumber the room number to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Returns the room type.
     * 
     * @return the room type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the room type.
     * 
     * @param type the room type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the maximum number of guests allowed in the room.
     * 
     * @return the maximum number of guests allowed
     */
    public int getNumMaxGuests() {
        return numMaxGuests;
    }

    /**
     * Sets the maximum number of guests allowed in the room.
     * 
     * @param numMaxGuests the maximum number of guests to set
     */
    public void setNumMaxGuests(int numMaxGuests) {
        this.numMaxGuests = numMaxGuests;
    }

    /**
     * Returns the space in meters of the room.
     * 
     * @return the space in meters
     */
    public int getSpaceInMeters() {
        return spaceInMeters;
    }

    /**
     * Sets the space in meters of the room.
     * 
     * @param spaceInMeters the space in meters to set
     */
    public void setSpaceInMeters(int spaceInMeters) {
        this.spaceInMeters = spaceInMeters;
    }

    /**
     * Returns the hotel to which the room belongs.
     * 
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the hotel to which the room belongs.
     * 
     * @param hotel the hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Returns the prize of the room.
     * 
     * @return the prize of the room
     */
    public float getPrize() {
        return prize;
    }

    /**
     * Sets the prize of the room.
     * 
     * @param prize the prize to set
     */
    public void setPrize(float prize) {
        this.prize = prize;
    }

    /**
     * Returns the list of bookings for the room.
     * 
     * @return the list of bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * Sets the list of bookings for the room.
     * 
     * @param bookings the list of bookings to set
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}