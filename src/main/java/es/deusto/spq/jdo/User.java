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



/**
 * The User class represents a user in the system.
 */
@PersistenceCapable(detachable = "true")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
    private String nick;
    private String lastname;
    private String password;

    /**
     * Constructs a User object with the given nick and password.
     * 
     * @param nick     the nickname of the user
     * @param password the password of the user
     */
    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    /**
     * Constructs a User object with the given nick, lastname, and password.
     * 
     * @param nick     the nickname of the user
     * @param lastname the lastname of the user
     * @param password the password of the user
     */
    public User(String nick, String lastname, String password) {
        this.nick = nick;
        this.lastname = lastname;
        this.password = password;
    }

    /**
     * Returns the lastname of the user.
     * 
     * @return the lastname of the user
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the user.
     * 
     * @param lastname the lastname of the user to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the nickname of the user.
     * 
     * @return the nickname of the user
     */
    public String getNick() {
        return nick;
    }

    /**
     * Sets the nickname of the user.
     * 
     * @param nick the nickname of the user to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * Returns the password of the user.
     * 
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password the password of the user to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the User object.
     * 
     * @return a string representation of the User object
     */
    @Override
    public String toString() {
        return "User [nick=" + nick + ", password=" + password + "]";
    }

    /**
     * Returns a string representation of the User object including the lastname.
     * 
     * @return a string representation of the User object including the lastname
     */
    public String toString2() {
        return "User [nick=" + nick + ", lastname=" + lastname + ", password=" + password + "]";
    }
}