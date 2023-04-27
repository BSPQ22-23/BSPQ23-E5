package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

public class Booking {
	
	public static Booking fromJSON(JSONObject object) {
		Calendar c = Calendar.getInstance();
		int startdate = object.getInt("checkinDate");
		c.set(Calendar.DAY_OF_YEAR, startdate%365);
		c.set(Calendar.YEAR, (int)startdate/365);
		Date sd = c.getTime();
		
		int enddate = object.getInt("checkoutDate");
		c.set(Calendar.DAY_OF_YEAR, enddate%365);
		c.set(Calendar.YEAR, (int)enddate/365);
		Date ed = c.getTime();
		
		Room r = Room.fromJSON(object.getJSONObject("room"));
		
		List<Guest> guests = new LinkedList<>();
		for(Object o : object.getJSONArray("guests")) 
			guests.add(Guest.fromJSON((JSONObject)o));
		return new Booking(sd, ed, r, guests, object.keySet().contains("author")?Guest.fromJSON(object.getJSONObject("author")):null);
    }
	
	private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private Room room;
    private Guest author;

	private List<Guest> guests;
    
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
    
    public void setAuthor(Guest author) {
    	this.author = author;
    }
    
    public Guest getAuthor() {
		return author;
	}
    
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        guests.remove(guest);
    }
}
