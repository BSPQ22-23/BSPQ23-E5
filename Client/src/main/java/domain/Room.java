package domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import domain.Booking;
import domain.Hotel;
import remote.APIUtils;

public class Room {
	private int roomNumber;
    private String type;
    private int numMaxGuests;
    private int spaceInMeters;
    private float prize;
    private List<Booking> bookings;
    private Hotel hotel;

    
    
    public Room(int roomNumber, String type, int numMaxHosts, int spaceInMeters, float prize, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.numMaxGuests = numMaxHosts;
        this.spaceInMeters = spaceInMeters;
        this.prize = prize;
        this.bookings = new ArrayList<>();
        this.hotel = hotel;
    }
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking guest) {
        bookings.add(guest);
    }

    public void removeBooking(Booking guest) {
        bookings.remove(guest);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getSpaceInMeters() {
		return spaceInMeters;
	}

	public void setSpaceInMeters(int spaceInMeters) {
		this.spaceInMeters = spaceInMeters;
	}

	public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public float getPrize() {
    	return prize;
    }
    public void setPrize(float prize) {
    	this.prize = prize;
    }
    public int getNumMaxGuests() {
        return numMaxGuests;
    }

    public void setNumMaxGuests(int numMaxHosts) {
        this.numMaxGuests = numMaxHosts;
    }

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
