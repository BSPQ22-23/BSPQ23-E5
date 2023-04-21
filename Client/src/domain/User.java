package domain;

public class User {

	private String nick;
	private String password;
	private Guest legalInfo;
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
	}
	public User(String nick, String password, Guest legalInfo) {
		super();
		this.nick = nick;
		this.password = password;
		this.legalInfo = legalInfo;
	}
}