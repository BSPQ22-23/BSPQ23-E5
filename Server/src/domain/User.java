package domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Transactional;
import javax.jdo.annotations.Unique;

import org.json.JSONObject;

import api.APIUtils;

@PersistenceCapable(detachable="true")
public class User {
	
	public static User fromJSON(JSONObject obj) {
		return new User(
				APIUtils.decode(obj.getString("nick")),
				PasswordEncryption.encryptPassword(APIUtils.decode(obj.getString("password"))),
				Guest.fromJSON(obj.getJSONObject("legalInfo")),
				obj.getBoolean("isHotelOwner")
			);
	}
	@PrimaryKey
	@Persistent
	private String nick;
	private String password;
	@Unique
	@Transactional
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
	public boolean equals(Object o) {
		return o instanceof User && ((User)o).nick.equals(nick);
	}

	public User(String nick, String password, Guest legalInfo, boolean isHotelOwner) {
		super();
		this.nick = nick;
		this.password = password;
		this.legalInfo = legalInfo;
		this.isHotelOwner = isHotelOwner;
	}
}
