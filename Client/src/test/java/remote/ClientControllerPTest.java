package remote;

import static org.junit.Assert.*;

import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.logging.LogManager;
import java.util.logging.Logger;



import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import domain.User;
import remote.ClientController;
import remote.ClientController.Response;
import junit.framework.JUnit4TestAdapter;

public class ClientControllerPTest {
	
	private ServiceLocator handler;
	//private static final Logger logger = LogManager.addLogger(ClientControllerPTest.class);
	private User user1;
	private ClientController controller;
	
	@Rule 
	public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ClientControllerPTest.class);
	}

	@Before
	public void setUp() throws Exception {
		handler = new ServiceLocator("localhost", 8000);
		handler.setService("localhost", 8000);
		System.out.println(handler);
		ClientController.setServerHandler(handler);
		
		HttpResponse<String> response = handler.sendGET("/ping");
		assertEquals(200, response.statusCode());
		
		}

		  
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetServerHandler() {
		
	}

	
	@Test(timeout = 5000) // 5 segundos de tiempo máximo para la ejecución del test
	public void testRegister() {
		// logger.info("Starting testRegisterUser");  
		  long startTime = System.currentTimeMillis();
		// Crear un nuevo usuario public User(String nick, String password, Guest legalInfo, boolean isHotelOwner) {
	        User user = new User("Maitane", "password123", false,null);
	        Response response;
			try {
				response = ClientController.register(user);
				if(response.status!= Response.SUCCESS) {
					 assertEquals(200, response.status);
				
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
	       
	        long endTime = System.currentTimeMillis();
	        long executionTime = endTime - startTime;
	
	  
	}

	@Test
	public void testLogin() {
		
	}

}
