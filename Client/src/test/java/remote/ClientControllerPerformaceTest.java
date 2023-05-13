package remote;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.Test;

import domain.Guest;
import domain.User;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import remote.ClientController;
import remote.ClientController.Response;

import org.junit.Rule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.Test;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import org.junit.Rule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientControllerPerformaceTest {
	private static final Logger logger = LogManager.getLogger(ClientControllerPerformaceTest.class);
	private User user1;
	private User user2;
	private ClientController clientcontroller;
	private ServiceLocator handler;
	@Rule 
	public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ClientControllerPerformaceTest.class);
	}

	  @Test(timeout = 5000) // 5 segundos de tiempo máximo para la ejecución del test
	  
	  
	    public void testRegisterUser() throws Exception {
		  
		  
		  ClientController.setServerHandler(new ServiceLocator("localhost", 8080));
		  
	      logger.info("Starting testRegisterUser");  
		  long startTime = System.currentTimeMillis();
		// Crear un nuevo usuario public User(String nick, String password, Guest legalInfo, boolean isHotelOwner) {
	        User user1 = new User("Maitane", "password123", false,null);
	        User user2 = new User("Gorka", "password124", true,null);
	        // Realizar el registro del usuario
	        Response response = ClientController.register(user1);
	
	        // Verificar que el registro fue exitoso
	        assertEquals(200, response.status);
	        
	        long endTime = System.currentTimeMillis();
	        long executionTime = endTime - startTime;
	
	  }
	
}