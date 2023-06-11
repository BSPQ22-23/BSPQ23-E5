package es.deusto.spq.pojo;




import java.util.List;


import es.deusto.spq.jdo.Guest;
/**
 * 
 * @author maitane
 *
 */
public class BookingData {

	
		
		
		private String checkinDate;
		private String checkoutDate;
		private String room;
		private String guest_name;
		private String type;

	

		public BookingData(String checkinDate, String checkoutDate, String room, String guest_name, String type) {
			super();
			this.checkinDate = checkinDate;
			this.checkoutDate = checkoutDate;
			this.room = room;
			this.guest_name = guest_name;
			this.type = type;
			
		}

		public BookingData() {
			
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
		 * Returns the check-in date.
		 * 
		 * @return the check-in date
		 */
		public String getCheckinDate() {
			return checkinDate;
		}

		/**
		 * Sets the check-in date.
		 * 
		 * @param checkinDate the check-in date to set
		 */
		public void setCheckinDate(String checkinDate) {
			this.checkinDate = checkinDate;
		}

		/**
		 * Returns the check-out date.
		 * 
		 * @return the check-out date
		 */
		public String getCheckoutDate() {
			return checkoutDate;
		}

		/**
		 * Sets the check-out date.
		 * 
		 * @param checkoutDate the check-out date to set
		 */
		public void setCheckoutDate(String checkoutDate) {
			this.checkoutDate = checkoutDate;
		}

		
		@Override
		public String toString() {
			return "Booking  :  checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + ", room=" + room
					+ ", guest_name=" + guest_name + ", type=" + type ;
		}
	

}
