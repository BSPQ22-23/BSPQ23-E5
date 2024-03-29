package es.deusto.spq.jdo;





import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.server.Guest;


import javax.jdo.annotations.PersistenceCapable;



/**
 * The Booking class represents a booking made by a guest.
 */
@PersistenceCapable(detachable = "true")
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	private String guest_name;
	private String checkinDate;
	private String checkoutDate;
	private String room;
	private String type;

	

	

	
	

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	
	public Booking(String guest_name, String checkinDate, String checkoutDate, String room, String type) {
		super();
		this.guest_name = guest_name;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.room = room;
		this.type = type;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}



	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	
	

	@Override
	public String toString() {
		return "Booking  : checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", room=" + room
				+ ", guest_name=" + guest_name + ", type=" + type ;
	}
	
}