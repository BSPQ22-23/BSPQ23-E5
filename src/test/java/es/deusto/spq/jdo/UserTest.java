package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import es.deusto.spq.jdo.User;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	    private String nick;
	    private String password;
	    private String lastname ;
	    @Before
	    public void setUp() {
	        nick = "johnDoe";
	        lastname = "B";
	        password = "password123";
	       user = new User(nick,lastname ,password);
	    }

	    @Test
	    public void testGetNick() {
	        assertEquals(nick, user.getNick());
	    }

	    @Test
	    public void testSetNick() {
	        String newNick = "jDoe";
	        user.setNick(newNick);
	        assertEquals(newNick, user.getNick());
	    }

	    @Test
	    public void testGetPassword() {
	        assertEquals(password, user.getPassword());
	    }

	    @Test
	    public void testSetPassword() {
	        String newPassword = "newPassword123";
	        user.setPassword(newPassword);
	        assertEquals(newPassword, user.getPassword());
	    }
	    @Test
	    public void testGetLastname() {
	    	assertEquals(lastname, user.getLastname());
	    }
	    @Test
	    public void testSetLastname() {
	        String newL= "a";
	        user.setLastname(newL);
	        assertEquals(newL, user.getLastname());
	    }
}
