package domain;

import java.util.Date;
import java.util.List;

public class Booking {
	private int id;
    private Date checkinDate;
    private Date checkoutDate;
    private Room room;
    private List<Guest> guests;

    public Booking(Date checkinDate, Date checkoutDate, Room room, List<Guest> guests) {
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.room = room;
        this.guests = guests;
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

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        guests.remove(guest);
    }
}
