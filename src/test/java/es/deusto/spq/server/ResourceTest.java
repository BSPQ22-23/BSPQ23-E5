package es.deusto.spq.server;

import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.jdo.User;
import es.deusto.spq.pojo.BookingData;
import es.deusto.spq.pojo.UserData;


public class ResourceTest {
	private static final PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("datanucleus.properties");

		private static Resource source;
		private static WebTarget target;

	@Before
	public void setUp() throws Exception {
		
		// create the client
				Client c = ClientBuilder.newClient();
				target = c.target("http://localhost:8080/rest").path("resource");
	}

	@After
	public void tearDown() throws Exception {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.newQuery(User.class).deletePersistentAll();

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	@Test
	public void testResource() {
		
	}

	@Test
	public void testRegister() {
		Resource resource = new Resource();
        UserData userData = new UserData("A", "A");

        Response response = resource.register(userData);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void testLoginUser() {
		 Resource resource = new Resource();
	        UserData userData = new UserData("A", "A");
	        Response response = resource.loginUser(userData);
	        assertNotEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	public void testCreateReservation() {
		Resource resource = new Resource();
		BookingData bookingData = new BookingData("Name","03-04-2024","08-04-2023","room45","Single");
		Response response = resource.createReservation(bookingData);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
}
