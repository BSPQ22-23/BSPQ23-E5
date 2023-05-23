package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	  private User user;
	    private String nick;
	    private String password;
	    private String dni;
	    private int age;
	    private String cityOfProvenance;
	    private Guest legalInfo;
	    private boolean isHotelOwner;

	    @Before
	    public void setUp() {
	        nick = "johnDoe";
	        password = "password123";
	        dni = "123456789";
	        age = 30;
	        cityOfProvenance = "New York";
	        isHotelOwner = true;

	        legalInfo = new Guest("John", "Doe", dni, age, cityOfProvenance);

	        user = new User(nick, password, dni, age, cityOfProvenance, isHotelOwner);
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
	    public void testGetDni() {
	        assertEquals(dni, user.getDni());
	    }

	    @Test
	    public void testSetDni() {
	        String newDni = "987654321";
	        user.setDni(newDni);
	        assertEquals(newDni, user.getDni());
	    }

	    @Test
	    public void testGetAge() {
	        assertEquals(age, user.getAge());
	    }

	    @Test
	    public void testSetAge() {
	        int newAge = 35;
	        user.setAge(newAge);
	        assertEquals(newAge, user.getAge());
	    }

	    @Test
	    public void testGetCityOfProvenance() {
	        assertEquals(cityOfProvenance, user.getCityOfProvenance());
	    }

	    @Test
	    public void testSetCityOfProvenance() {
	        String newCityOfProvenance = "Los Angeles";
	        user.setCityOfProvenance(newCityOfProvenance);
	        assertEquals(newCityOfProvenance, user.getCityOfProvenance());
	    }

	    @Test
	    public void testGetLegalInfo() {
	        assertNotEquals(legalInfo, user.getLegalInfo());
	    }

	    @Test
	    public void testSetLegalInfo() {
	        es.deusto.spq.server.Guest newLegalInfo = new es.deusto.spq.server.Guest("Jane", "Smith", "987654321", 25, "Chicago");
	        user.setLegalInfo(newLegalInfo);
	        assertEquals(newLegalInfo, user.getLegalInfo());
	        assertEquals(newLegalInfo.getDni(), user.getDni());
	    }

	    @Test
	    public void testIsHotelOwner() {
	        assertEquals(isHotelOwner, user.isHotelOwner());
	    }

	    @Test
	    public void testSetHotelOwner() {
	        boolean newIsHotelOwner = false;
	        user.setHotelOwner(newIsHotelOwner);
	        assertEquals(newIsHotelOwner, user.isHotelOwner());
	    }

}
