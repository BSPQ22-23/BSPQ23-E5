package es.deusto.spq.client;

import static org.junit.Assert.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.deusto.spq.pojo.UserData;
import javassist.CtBehavior;
/**
 * CLIENT CONTROLLER USANDO MOCKITO
 * @author BSILV
 *
 */
public class ClientControllerTest {
	@Mock
	private static Client client;
	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private  static WebTarget webTarget;
	@Captor
	private ArgumentCaptor<Entity<UserData>> userDataEntityCaptor;

	private static ClientController controller;
	public ClientControllerTest ct;

	
	
	@Before
	public  void setUp() {
		
		MockitoAnnotations.openMocks(this);


		// prepare static mock of ClientBuilder
				try (MockedStatic<ClientBuilder> clientBuilder = Mockito.mockStatic(ClientBuilder.class)) {
					clientBuilder.when(ClientBuilder::newClient).thenReturn(client);
					when(client.target("http://localhost:8080/rest/resource")).thenReturn(webTarget);
		controller = new ClientController("localhost", "8080");
			}
	}
	@After
	public void teardown()
	{
		
	}
	

	@Test
	public void testLogin() {
		when(webTarget.path("login")).thenReturn(webTarget);

		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);

	}
	
	@Test
	public void testLoginWithError() {
		webTarget = webTarget.path("login");
		Response response = Response.serverError().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);

		
	}

	@Test
	public void testRegister() {
		webTarget = webTarget.path("register");
		Response response = Response.ok().build();
		when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);

	}
	

}
