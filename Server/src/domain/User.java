package domain;

public class User {
	private String username;
	private String email;
	private Guest legalInfo;
	private boolean isHotelOwner;
	public User(String username, String email, Guest legalInfo, boolean isHotelOwner) {
		this.username = username;
		this.email = email;
		this.legalInfo = legalInfo;
		this.isHotelOwner = isHotelOwner;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public Guest getLegalInfo() {
		return legalInfo;
	}
}
