package es.deusto.spq.jdo;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Transactional;
import javax.jdo.annotations.Unique;

import es.deusto.spq.server.*;
import es.deusto.spq.server.Guest;
import es.deusto.spq.server.dao.GuestDAO;



@PersistenceCapable(detachable="true")
public class User {
	
	
	
	@Persistent
	private String nick;
	private String password;
	private String dni;
	private int age;
	private String cityOfProvenance;
	private Guest legalInfo;
	private boolean isHotelOwner;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCityOfProvenance() {
		return cityOfProvenance;
	}
	public void setCityOfProvenance(String cityOfProvenance) {
		this.cityOfProvenance = cityOfProvenance;
	}


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
	public Guest getLegalInfo() {
		
		return legalInfo;
	}
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
	/*public boolean equals(Object o) {
		return o instanceof User && ((User)o).nick.equals(nick);
	}*/

	public User(String nick, String password, String dni, int age, String cityOfProvenance, boolean isHotelOwner) {
		super();
		this.nick = nick;
		this.password = password;
		this.dni = dni;
		this.age = age;
		this.cityOfProvenance = cityOfProvenance;
		this.isHotelOwner = isHotelOwner;
	}
	/*public User(String nick, String password, Guest legalInfo, boolean isHotelOwner) {
		
		this.nick = nick;
		this.dni = legalInfo.getDni();
		this.password = password;
		this.legalInfo = legalInfo;
		this.isHotelOwner = isHotelOwner;
	}*/
	/*public User() {
		// TODO Auto-generated constructor stub
	}*/
}