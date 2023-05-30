package es.deusto.spq.jdo;





import java.util.Date;

import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;


import es.deusto.spq.server.Guest;
import es.deusto.spq.server.Room;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable(detachable="true")
public class Booking {
	
	
	
	
	
	@Persistent
	private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private Room room;
    private Guest author;

    @Join
	private List<Guest> guests;
    
    public Booking(Integer id,   Date checkinDate, Date checkoutDate, Room room, List<Guest> guests, Guest author) {
        this.id = id;
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
