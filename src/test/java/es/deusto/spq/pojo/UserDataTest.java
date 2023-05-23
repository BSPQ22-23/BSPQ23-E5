package es.deusto.spq.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDataTest {
	 UserData userData;
	@Before
	public void setUp() throws Exception {
		userData = new UserData();
        userData.setDni("dni");
        userData.setNickname("nick");
        userData.setLastname("lastn");
        userData.setPassword("passwd");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDni() {
		assertEquals("dni", userData.getDni());
	}

	@Test
	public void testGetNickname() {
		assertEquals("nick",userData.getNickname());
	}

	@Test
	public void testGetLastname() {
		assertEquals("lastn",userData.getLastname());
	}
	@Test
	public void testGetPassword() {
		assertEquals("passwd",userData.getPassword());
	}
	@Test
	public void testUserDataStringStringStringStringIntegerStringBoolean() {
		
	}

	@Test
	public void testUserDataStringStringBoolean() {
		
	}

	@Test
	public void testGetIsHotelOwner() {
		
	}

	@Test
	public void testSetIsHotelOwner() {
		
	}

	

	@Test
	public void testSetDni() {
		
	}

	

	@Test
	public void testSetNickname() {
		
	}

	

	@Test
	public void testSetLastname() {
		
	}

	@Test
	public void testGetCity() {
		
	}

	@Test
	public void testSetCity() {
		
	}

	@Test
	public void testGetAge() {
		
	}

	@Test
	public void testSetAge() {
		
	}

	@Test
	public void testUserData() {
		
	}

	@Test
	public void testGetLogin() {
		
	}

	@Test
	public void testSetLogin() {
		
	}

	

	@Test
	public void testSetPassword() {
		
	}

	@Test
	public void testToStringLogin() {
			}

	@Test
	public void testToStringRegister() {
		
	}

}
