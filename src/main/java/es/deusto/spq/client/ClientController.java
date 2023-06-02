package es.deusto.spq.client;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;



import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.Room;
import es.deusto.spq.util.LoginWindow;
import es.deusto.spq.util.MainMenuClient;
import es.deusto.spq.util.VentanaPrincipal;
import es.deusto.spq.jdo.Booking;
import es.deusto.spq.jdo.Guest;
import es.deusto.spq.jdo.Hotel;

public class ClientController {
	protected static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	//private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	private static final String USER = "M";
	private static final String PASSWORD = "M";

	private Client client;
	private static WebTarget webTarget;
/**
 * Establecer la conexion con el servidor
 * @param hostname
 * @param port
 */
	public ClientController(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));
		System.out.println(String.format("Este es la ip :%s este es el puesto :%s",hostname,port));

	}
/**
 * Login method
 * @param name
 * @param password
 */
	public void login(String name, String password) {
		WebTarget registerUserWebTarget = webTarget.path("login");
		System.out.println(String.format("Entra al paquete del login", registerUserWebTarget));
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UserData userData = new UserData();
		userData.setNickname(name);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		System.out.println(String.format("La respuesta del cliente :", response));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			// logger.error("Error connecting with the server. Code: {}",
			response.getStatus();
			System.out.println(String.format("Error connecting with the server. Code: {}", response.getStatus()));
			
		} else {
			System.out.println("User correctly logged");
			logger.info("User correctly logged");
			MainMenuClient mmc = new MainMenuClient();
			mmc.setVisible(true);

		}
	}
/**
 * Register method
 * @param id
 * @param nickname
 * @param lastname
 * @param city
 * @param age
 * @param password
 */
	public void register( String nickname, String lastname,
			String password) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UserData userData = new UserData();
		userData.setNickname(nickname);
		userData.setLastname(lastname);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			  logger.error("Error connecting with the server. Code: {}",
			response.getStatus());
		} else {
			 logger.info("User correctly registered");
		}
	}

	
	
	
	
	
	
	

	public static void main(String[] args) {
		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}
		String hostname = args[0];
		String port = args[1];
		
		

	ClientController controller =	new ClientController(hostname, port);
	//new VentanaPrincipal(controller);
	//controller.login(USER, PASSWORD);
	new LoginWindow(controller);
	
	
		

	}
}