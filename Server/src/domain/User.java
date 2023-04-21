package domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class User {
	@PrimaryKey
	@Persistent
	private String nick;
	private String password;
	@Persistent
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
