package es.deusto.spq.server;

import static org.junit.Assert.*;



import java.net.URI;
import java.util.UUID;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;




import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import es.deusto.spq.*;
import es.deusto.spq.jdo.User;
import es.deusto.spq.pojo.BookingData;
import es.deusto.spq.pojo.UserData;

import org.junit.experimental.categories.Category;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import categories.PerformanceTest;



@Category(PerformanceTest.class)
public class ResourcePerfomaceTest {
	private static final PersistenceManagerFactory pmf = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");

	private static Resource source;
	private static WebTarget target;

	@Rule
	public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

	@BeforeClass
	public  static void setUp() throws Exception {
		// create the client
		Client c = ClientBuilder.newClient();
		target = c.target("http://localhost:8080/rest").path("resource");

	
	}

	@AfterClass
	public static void tearDown() throws Exception {
		

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
	
	@JUnitPerfTest(threads = 10, durationMs = 10_000, warmUpMs = 1_000, maxExecutionsPerSecond = 100)
	public void testRegister() {
		Resource resource = new Resource();
		UserData user = new UserData();
		user.setNickname("M");
		user.setLastname("M");
		user.setPassword("M");

		Response response = resource.register(user);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		
		 
		
	}

	@Test
	
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100) // <-- allow 1% of executions to be errors
	public void testLoginUser() {
		Resource resource = new Resource();
		UserData user = new UserData();
		user.setNickname("M");
		user.setPassword("M");
		Response response = resource.loginUser(user);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	@Test
	@JUnitPerfTest(threads = 10, durationMs = 10_000, warmUpMs = 1_000, maxExecutionsPerSecond = 100)
	
	public void testCreateReservation() {
		Resource resource = new Resource();
		BookingData bookingdata = new BookingData();
		 bookingdata.setGuest_name("name");
	        bookingdata.setCheckinDate("03-04-2024");
	        bookingdata.setCheckoutDate("08-04-2024");
	        bookingdata.setRoom("room45");
	        bookingdata.setType("Single");
		Response response = resource.createReservation(bookingdata);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

}
