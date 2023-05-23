package es.deusto.spq.server.domain;
import es.deusto.spq.server.dao.*;


public class User {
	
	@Override
	public String toString() {
		return "User [nick=" + nick + ", password=" + password + ", dni=" + dni + ", legalInfo=" + legalInfo
				+ ", isHotelOwner=" + isHotelOwner + "]";
	}
	
	private String nick;
	private String password;
	
	private String dni;

	private Guest legalInfo;
	private boolean isHotelOwner;
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public Guest getLegalInfo() {
		if(legalInfo == null && dni != null)
			return (legalInfo = GuestDAO.getInstance().find(dni));
		return legalInfo;
	}*/
	public void setLegalInfo(Guest legalInfo) {
		this.legalInfo = legalInfo;
		this.dni = legalInfo.getDni();
	}
	public boolean isHotelOwner() {
		return isHotelOwner;
	}

	public void setHotelOwner(boolean isHotelOwner) {
		this.isHotelOwner = isHotelOwner;
	}
	public boolean equals(Object o) {
		return o instanceof User && ((User)o).nick.equals(nick);
	}

	public User(String nick, String password, Guest legalInfo, boolean isHotelOwner) {
		super();
		this.nick = nick;
		this.dni = legalInfo.getDni();
		this.password = password;
		this.legalInfo = legalInfo;
		this.isHotelOwner = isHotelOwner;
	}
}
