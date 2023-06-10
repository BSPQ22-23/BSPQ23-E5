package es.deusto.spq.server;

import java.util.Date;
import java.util.List;


import es.deusto.spq.server.Guest;

public class Booking {

	
		
		private int id;
		private Date checkinDate;
		private Date checkoutDate;
		private String room;
		private String guest_name;
		private String type;

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
		 * @return 
		 */
		public Booking(Date checkinDate, Date checkoutDate, String room, String guest_name ,String type) {
		
			this.checkinDate = checkinDate;
			this.checkoutDate = checkoutDate;
			this.room = room;
			this.type= type;
			this.guest_name= guest_name;
		}
		public Booking() {
		}

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

		@Override
		public String toString() {
			return "Booking  : id=" + id + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", room=" + room
					+ ", guest_name=" + guest_name + ", type=" + type ;
		}
	

}
