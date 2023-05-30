package es.deusto.spq.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Transactional;
import javax.jdo.annotations.Unique;

import es.deusto.spq.server.*;
import es.deusto.spq.server.Guest;
import es.deusto.spq.server.dao.GuestDAO;



@PersistenceCapable
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	@Persistent
	@Unique
	private String nick = null;
	@Persistent
	private String password = null;

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

	/*public boolean equals(Object o) {
		return o instanceof User && ((User)o).nick.equals(nick);
	}*/

	
	public User(String nick,String password ) {
		this.nick = nick;
		
		this.password = password;
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
	public String toString() {
		return "nNck=" + nick + ", password=" + password + "]";
	}
	
	
}

