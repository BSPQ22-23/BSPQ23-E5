package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.domain.Guest;
import com.domain.User;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;
    private domain.Guest guest;

    @Before
    public void setUp() {
        guest = new domain.Guest("John", "Doe", "12345678A", 30, "New York");
        user = new User("johndoe", "password", false, guest);
    }

    @Test
    public void testGetNick() {
        assertEquals("johndoe", user.getNick());
    }

    @Test
    public void testSetNick() {
        user.setNick("jane");
        assertEquals("jane", user.getNick());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testIsHotelOwner() {
        assertEquals(false, user.isHotelOwner());
    }

    @Test
    public void testSetHotelOwner() {
        user.setHotelOwner(true);
        assertEquals(true, user.isHotelOwner());
    }

    @Test
    public void testGetLegalInfo() {
        assertNotNull(user.getLegalInfo());
        assertEquals("John", user.getLegalInfo().getName());
        assertEquals("Doe", user.getLegalInfo().getSurname());
        assertEquals("12345678A", user.getLegalInfo().getDni());
        assertEquals(30, user.getLegalInfo().getAge());
        assertEquals("New York", user.getLegalInfo().getCityOfProvenance());
    }

   
}