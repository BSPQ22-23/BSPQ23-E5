package es.deusto.spq.client;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

public class ClientControllerTest {
	private Client client;
	private WebTarget webTarget;
	private ClientController controller;

	
	
	@Before
	public void setUp() {
		

		client = ClientBuilder.newClient();
		webTarget =client.target("http://localhost:8080/rest/resource");
		controller = new ClientController("localhost", "8080");
		
	}

	
	

	@Test
	public void testLogin() {
		webTarget = webTarget.path("login");
		Response response = Response.ok().build();
		
	}
	
	@Test
	public void testLoginWithError() {
		webTarget = webTarget.path("login");
		Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(null));
		assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
		
	}

	@Test
	public void testRegister() {
		webTarget = webTarget.path("register");
		Response response = Response.ok().build();
	}
	@Test
	public void testCreateReservation() {
		
	}
	@Test
	public void testGetHotel() {
		
	}

}
