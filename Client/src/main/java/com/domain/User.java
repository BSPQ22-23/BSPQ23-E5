package com.domain;



public class User {

	private String nick;
	private String password;
	private boolean isHotelOwner;
	private Guest legalInfo;
	public String getNick() {
		return nick;
	}
	public User(String nick, String password, boolean isHotelOwner, Guest legalInfo) {
		
		this.nick = nick;
		this.password = password;
		this.isHotelOwner = isHotelOwner;
		this.legalInfo = legalInfo;
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
	}
	public boolean isHotelOwner() {
		return isHotelOwner;
	}

	public void setHotelOwner(boolean isHotelOwner) {
		this.isHotelOwner = isHotelOwner;
	}

	
}