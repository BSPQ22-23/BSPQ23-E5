package es.deusto.spq.client;

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


import org.glassfish.jersey.server.ResourceConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import es.deusto.spq.*;
import es.deusto.spq.jdo.User;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.Resource;

import org.junit.experimental.categories.Category;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import categories.PerformanceTest;



//@Category(PerformanceTest.class)
public class ResourcePerfomaceTest {
	private static final PersistenceManagerFactory pmf = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");

	private static Resource resource;
	private static  WebTarget target;

	@Rule
	public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

	@BeforeClass
	public  static void setUp() throws Exception {
		// create the client
		Client c = ClientBuilder.newClient();
		target = c.target("http://localhost:8080/rest").path("resource");
		resource  = new Resource();
		/* server
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
		ResourceConfig config = new ResourceConfig(Resource.class);
		server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);*/
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
	
    @JUnitPerfTest(threads = 2, durationMs = 10000)
	//@JUnitPerfTestRequirement(meanLatency = 500) // <-- allow 1% of executions to be errors
	public void testRegister() {
		UserData user = new UserData();
		user.setNickname("Juan");
		user.setLastname("Garcia");
		user.setPassword("1234");

		
		  Response response = target.path("register")
		  .request(MediaType.APPLICATION_JSON) .post(Entity.entity(user,
		  MediaType.APPLICATION_JSON));
		  
		  assertNotEquals(Response.Status.OK, response.getStatusInfo());
		
	}

	@Test
	
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100) // <-- allow 1% of executions to be errors
	public void testLoginUser() {
		UserData user = new UserData();
		user.setNickname("B");
		user.setPassword("B");
		/*
		 * Response response = target.path("login") .request(MediaType.APPLICATION_JSON)
		 * .post(Entity.entity(user, MediaType.APPLICATION_JSON));
		 * 
		 * assertNotEquals(Response.Status.OK, response.getStatusInfo());
		 */
	}

}
