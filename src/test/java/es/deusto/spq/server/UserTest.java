package es.deusto.spq.server;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.*;

public class UserTest {
	 private User user;
	    private Guest legalInfo;

	    @Before
	    public void setUp() {
	        legalInfo = new Guest("John", "Doe", "123456789", 30, "New York");
	        user = new User("johndoe", "password123", legalInfo, true);
	    }

	    @Test
	    public void testGetNick() {
	        assertEquals("johndoe", user.getNick());
	    }

	    @Test
	    public void testSetNick() {
	        user.setNick("johnsmith");
	        assertEquals("johnsmith", user.getNick());
	    }

	    @Test
	    public void testGetPassword() {
	        assertEquals("password123", user.getPassword());
	    }

	    @Test
	    public void testSetPassword() {
	        user.setPassword("newpassword456");
	        assertEquals("newpassword456", user.getPassword());
	    }

	    @Test
	    public void testGetLegalInfo() {
	        assertEquals(legalInfo, user.getLegalInfo());
	    }

	    @Test
	    public void testSetLegalInfo() {
	        Guest newLegalInfo = new Guest("Jane", "Smith", "987654321", 28, "Los Angeles");
	        user.setLegalInfo(newLegalInfo);
	        assertEquals(newLegalInfo, user.getLegalInfo());
	    }

	    @Test
	    public void testIsHotelOwner() {
	        assertTrue(user.isHotelOwner());
	    }

	    @Test
	    public void testSetHotelOwner() {
	        user.setHotelOwner(false);
	        assertFalse(user.isHotelOwner());
	    }

	    @Test
	    public void testEquals() {
	        User user2 = new User("johndoe", "password123", legalInfo, true);
	        assertTrue(user.equals(user2));
	    }

}
