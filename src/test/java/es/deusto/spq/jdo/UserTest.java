package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	    private String nick;
	    private String password;
	    @Before
	    public void setUp() {
	        nick = "johnDoe";
	        password = "password123";
	       user = new User(nick,password);
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
}
