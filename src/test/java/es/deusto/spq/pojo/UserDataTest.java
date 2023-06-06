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
	        
	        userData.setNickname("nick");
	        userData.setLastname("lastn");
	        userData.setPassword("passwd");
		}

		@After
		public void tearDown() throws Exception {
		}

	@Test
	public void testUserDataStringStringString() {
		
	}

	@Test
	public void testUserDataStringString() {
		
	}

	@Test
	public void testUserData() {
		
	}


	@Test
	public void testSetNickname() {
		
	}

	

	@Test
	public void testSetLastname() {
		
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
	public void testSetPassword() {
		
	}

	@Test
	public void testToStringLogin() {
		
	}

	@Test
	public void testToStringRegister() {
		
	}

}
