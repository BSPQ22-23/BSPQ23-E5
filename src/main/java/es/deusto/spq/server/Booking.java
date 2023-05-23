package es.deusto.spq.server;

import java.util.Calendar;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;






public class Booking {
	
	
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
