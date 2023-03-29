package domain;

public class User {
	private String username;
	private String email;
	private Huesped legalInfo;
	public User(String username, String email, Huesped legalInfo) {
		super();
		this.username = username;
		this.email = email;
		this.legalInfo = legalInfo;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public Huesped getLegalInfo() {
		return legalInfo;
	}
}
