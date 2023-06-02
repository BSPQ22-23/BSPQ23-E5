package es.deusto.spq.server.domain;
import es.deusto.spq.server.dao.*;


/**
 * Represents a user in the system.
 */
public class User {
    private String nick;
    private String password;
    private String dni;
    private Guest legalInfo;
    private boolean isHotelOwner;

    /**
     * Constructs a User object with the specified details.
     *
     * @param nick         The username of the user.
     * @param password     The password of the user.
     * @param legalInfo    The guest's legal information associated with the user.
     * @param isHotelOwner Indicates whether the user is a hotel owner.
     */
    public User(String nick, String password, Guest legalInfo, boolean isHotelOwner) {
        this.nick = nick;
        this.password = password;
        this.dni = legalInfo.getDni();
        this.legalInfo = legalInfo;
        this.isHotelOwner = isHotelOwner;
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

    public boolean equals(Object o) {
        return o instanceof User && ((User) o).nick.equals(nick);
    }

    @Override
    public String toString() {
        return "User [nick=" + nick + ", password=" + password + ", dni=" + dni + ", legalInfo=" + legalInfo
                + ", isHotelOwner=" + isHotelOwner + "]";
    }
}
