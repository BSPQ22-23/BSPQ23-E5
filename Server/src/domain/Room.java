package domain;

import java.util.List;

import org.json.JSONObject;

import api.APIUtils;

public class Room {
	private int roomNumber;
    private String type;
    private int numMaxGuests;
    private int spaceInMeters;
    private Hotel hotel;//Mapped by Hotel#rooms
    private float prize;
    private List<Booking> bookings;
    
    public static Room fromJSON(JSONObject object) {
    	Room res = new Room(
			object.getInt("roomNumber"), 
			APIUtils.decode(object.getString("type")),
			object.getInt("numMaxGuests"),
			object.getInt("spaceInMeters"),
			object.getFloat("prize"),
			object.keySet().contains("hotel")?Hotel.fromJSON(object.getJSONObject("hotel")):null
		);
    	if(object.keySet().contains("bookings"))
    		for(Object o : object.getJSONArray("bookings"))
    			res.addBooking(Booking.fromJSON((JSONObject)o));
    	return res;
    }
    public Room(int roomNumber, String type, int numMaxHosts, int spaceInMeters, float prize, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.numMaxGuests = numMaxHosts;
        this.spaceInMeters = spaceInMeters;
        this.hotel = hotel;
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

    public Hotel getHotel() {
		return hotel;
	}
    public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public void setType(String type) {
        this.type = type;
    }
    public float getPrize() {
    	return prize;
    }
    public void setBookings(List<Booking> bookings) {
    	this.bookings = bookings;
    }
    public void addBooking(Booking booking) {
    	this.bookings.add(booking);
    }
    public List<Booking> getBookings(){
    	return bookings;
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

}
