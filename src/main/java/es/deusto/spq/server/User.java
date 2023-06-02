package es.deusto.spq.server;
import es.deusto.spq.server.dao.*;


/**
 * Represents a user of the hotel management system.
 */
public class User {

	private String nick;
	private String password;
	private String dni;
	private int age;
	private String cityOfProvenance;
	private Guest legalInfo;
	private boolean isHotelOwner;
	
	/**
	 * Constructs a new User object with the specified properties.
	 *
	 * @param nick             The nickname of the user.
	 * @param password         The password of the user.
	 * @param dni              The DNI (National Identity Document) of the user.
	 * @param age              The age of the user.
	 * @param cityOfProvenance The city of provenance of the user.
	 * @param isHotelOwner     A flag indicating if the user is a hotel owner.
	 */
	public User(String nick, String password, String dni, int age, String cityOfProvenance, boolean isHotelOwner) {
		this.nick = nick;
		this.password = password;
		this.dni = dni;
		this.age = age;
		this.cityOfProvenance = cityOfProvenance;
		this.isHotelOwner = isHotelOwner;
	}
	
	/**
	 * Constructs a new User object with the specified properties.
	 *
	 * @param nick         The nickname of the user.
	 * @param password     The password of the user.
	 * @param legalInfo    The legal information of the user (Guest object).
	 * @param isHotelOwner A flag indicating if the user is a hotel owner.
	 */
	public User(String nick, String password, Guest legalInfo, boolean isHotelOwner) {
		this.nick = nick;
		this.dni = legalInfo.getDni();
		this.password = password;
		this.legalInfo = legalInfo;
		this.isHotelOwner = isHotelOwner;
	}
	
	/**
	 * Returns the nickname of the user.
	 *
	 * @return The nickname of the user.
	 */
	public String getNick() {
		return nick;
	}
	
	/**
	 * Sets the nickname of the user.
	 *
	 * @param nick The nickname of the user.
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**
	 * Returns the password of the user.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password of the user.
	 *
	 * @param password The password of the user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Returns the legal information of the user (Guest object).
	 * If the legal information is not set but the DNI is available, it fetches and returns the Guest object from the database.
	 *
	 * @return The legal information of the user (Guest object).
	 */
	public Guest getLegalInfo() {
		if (legalInfo == null && dni != null) {
			return (legalInfo = GuestDAO.getInstance().find(dni));
		}
		return legalInfo;
	}
	
	/**
	 * Sets the legal information of the user (Guest object) and updates the DNI property accordingly.
	 *
	 * @param legalInfo The legal information of the user (Guest object).
	 */
	public void setLegalInfo(Guest legalInfo) {
		this.legalInfo = legalInfo;
		this.dni = legalInfo.getDni();
	}
	
	/**
	 * Returns a flag indicating if the user is a hotel owner.
	 *
	 * @return {@code true} if the user is a hotel owner, {@code false} otherwise.
	 */
	public boolean isHotelOwner() {
		return isHotelOwner;
	}

	/**
	 * Sets the flag indicating if the user is a hotel owner.
	 *
	 * @param isHotelOwner A flag indicating if the user is a hotel owner.
	 */
	public void setHotelOwner(boolean isHotelOwner) {
		this.isHotelOwner = isHotelOwner;
	}
	
	/**
	 * Checks if this User object is equal to the specified object.
	 * Two User objects are considered equal if their nicknames are equal.
	 *
	 * @param o The object to compare.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		return o instanceof User && ((User) o).nick.equals(nick);
	}
	
	/**
	 * Returns the DNI (National Identity Document) of the user.
	 *
	 * @return The DNI of the user.
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Sets the DNI (National Identity Document) of the user.
	 *
	 * @param dni The DNI of the user.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Returns the age of the user.
	 *
	 * @return The age of the user.
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the age of the user.
	 *
	 * @param age The age of the user.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Returns the city of provenance of the user.
	 *
	 * @return The city of provenance of the user.
	 */
	public String getCityOfProvenance() {
		return cityOfProvenance;
	}
	
	/**
	 * Sets the city of provenance of the user.
	 *
	 * @param cityOfProvenance The city of provenance of the user.
	 */
	public void setCityOfProvenance(String cityOfProvenance) {
		this.cityOfProvenance = cityOfProvenance;
	}
	
	/**
	 * Returns a string representation of the User object.
	 *
	 * @return A string representation of the User object.
	 */
	@Override
	public String toString() {
		return "User [nick=" + nick + ", password=" + password + ", dni=" + dni + ", legalInfo=" + legalInfo
				+ ", isHotelOwner=" + isHotelOwner + "]";
	}
}
