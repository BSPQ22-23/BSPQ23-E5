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
<<<<<<< HEAD
=======
import es.deusto.spq.util.VentanaPrincipal;
>>>>>>> 1bbcaec (update)
import es.deusto.spq.jdo.Booking;
import es.deusto.spq.jdo.Guest;
import es.deusto.spq.jdo.Hotel;

public class ClientController {
	protected static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	//private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	//private static final String USER = "dipina";
	//private static final String PASSWORD = "dipina";

	private Client client;
	private static WebTarget webTarget;
<<<<<<< HEAD

	public ClientController(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));

	}

	public void login(String name, String password) {
		WebTarget registerUserWebTarget = webTarget.path("login");
=======
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
>>>>>>> 1bbcaec (update)
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UserData userData = new UserData();
		userData.setNickname(name);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
<<<<<<< HEAD
=======
		System.out.println(String.format("La respuesta del cliente :", response));
>>>>>>> 1bbcaec (update)
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
<<<<<<< HEAD

	public static void register(String id, String nickname, String lastname, String city, Integer age,
=======
/**
 * Register method
 * @param id
 * @param nickname
 * @param lastname
 * @param city
 * @param age
 * @param password
 */
	public void register(String id, String nickname, String lastname, String city, 
>>>>>>> 1bbcaec (update)
			String password) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UserData userData = new UserData();
		userData.setNickname(nickname);
		userData.setCity(city);
		userData.setDni(id);
<<<<<<< HEAD
		userData.setAge(age);
=======
>>>>>>> 1bbcaec (update)
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

	
	
<<<<<<< HEAD
	/*
	 * Create a POST  - create a reservation
	 * @param b booking
	 * @return response of the create a reservation
	 
	public static Response createReservation(Booking b) {
		HashMap<String, String> headers = new HashMap<>();
		headers.put("token", token);
		HttpResponse<String> response;
		try {
			response = handler.sendPOST("booking/create", headers, APIUtils.objectToJSON(b));
			return new Response(response.statusCode(), response.body());
		} catch (URISyntaxException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}	
	}public Booking(Integer id,   Date checkinDate, Date checkoutDate, Room room, List<Guest> guests, Guest author) {*/
	public void createRerservation(Integer id, Date checkin, Date checkout, Room room , List<Guest> guest, Guest author ) {
		WebTarget createWebTarget = webTarget.path("booking/create");
		Invocation.Builder invocationBuilder = createWebTarget.request(MediaType.APPLICATION_JSON);
		Booking b = new Booking(id, checkin, checkout, room, null, null);
	
		b.setId(id);
		b.setCheckinDate(checkin);
		b.setCheckoutDate(checkout);
		b.setGuests(null);
		b.setAuthor(null);
	
		
		Response response = invocationBuilder.post(Entity.entity(b, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info(" correctly created the reservation");
		}
	}
=======
>>>>>>> 1bbcaec (update)
	
	
	
	
	
<<<<<<< HEAD
	
	
	
	
	
	/*
	 * /** GET HOTEL BY NAME
	 * 
	 * @param name
	 * 
	 * @return a list of hotels
	 *
	 * public static Hotel[] getHotels(String name) { HttpResponse<String> response;
	 * try { response = handler.sendGET("hotel/get", Map.of("token", token, "query",
	 * name)); if(response.statusCode() == 200) { String body = response.body(); if
	 * (body != null && !body.isEmpty()) { Hotel[] output =
	 * APIUtils.fromJsonString(body, Hotel[].class); return output; } return new
	 * Hotel[0]; } else { throw new Response(response.statusCode(),
	 * response.body()); } } catch (URISyntaxException | InterruptedException |
	 * ExecutionException | JsonProcessingException e) { e.printStackTrace(); return
	 * null; } }
	 */
	/**
	 * GET HOTEL BY NAME
	 * @param name
	 * @return a list of hotels
	 */
	public ArrayList<Hotel> getHotel(String name) {
		ArrayList<Hotel> hotel = new ArrayList<>();
		WebTarget gethotelWebTarget = webTarget.path("hotel/gethotel");
		Invocation.Builder invocationBuilder = gethotelWebTarget.request(MediaType.APPLICATION_JSON);
		Hotel h = new Hotel(name);
		h.getName();
		hotel.add(h);

		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly get the hotel");

		}
		return hotel;

	}
	/*
	 * /**
	 * GET RESERVATION BY ID
	 * @param id
	 * @return a reservation
	 *
	public static Booking getReservation(int id) {
		HttpResponse<String> response;
		try {
			response = handler.sendGET("booking/get", Map.of("token", token, "q", "single", "value", ""+id));
			if(response.statusCode() == 200) {
				 String json = response.body();
		            return APIUtils.fromJsonString(json, Booking.class);
		        }
			throw new Response(response.statusCode(), response.body());
		} catch (URISyntaxException | InterruptedException | ExecutionException | JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}*/
	/**
	 * GET RESERVATION BY ID
	 * @param id
	 * @return a reservation
	 */
	public static Booking getReservation(int id) {
		
		WebTarget gethotelWebTarget = webTarget.path("Booking/getRervation");
		Invocation.Builder invocationBuilder = gethotelWebTarget.request(MediaType.APPLICATION_JSON);
		Booking b = new Booking(id, null, null, null, null, null);
		b.getId();
		
		
		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			 logger.info("User correctly get the hotel");
			
		}
		return b;
	}

	/*
	 * public void sendDonation(int quantity) throws DonationException { WebTarget
	 * donationsWebTarget = webTarget.path("collector/donations");
	 * Invocation.Builder invocationBuilder =
	 * donationsWebTarget.request(MediaType.APPLICATION_JSON);
	 * 
	 * Donation donation = new Donation(quantity); Response response =
	 * invocationBuilder.post(Entity.entity(donation, MediaType.APPLICATION_JSON));
	 * if (response.getStatus() != Status.OK.getStatusCode()) { throw new
	 * DonationException("" + response.getStatus()); } }
	 * 
	 * public DonationInfo getDonationInfo() throws DonationException { WebTarget
	 * donationsWebTarget = webTarget.path("collector/donations");
	 * Invocation.Builder invocationBuilder =
	 * donationsWebTarget.request(MediaType.APPLICATION_JSON); Response response =
	 * invocationBuilder.get(); if (response.getStatus() ==
	 * Status.OK.getStatusCode()) { return response.readEntity(DonationInfo.class);
	 * } else { throw new DonationException("" + response.getStatus()); } }
	 * 
	 */
	public static void main(String[] args) {
=======

	public static void main(String[] args) {
		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}
>>>>>>> 1bbcaec (update)
		String hostname = args[0];
		String port = args[1];

	ClientController controller =	new ClientController(hostname, port);
<<<<<<< HEAD
	new LoginWindow(hostname, port);
=======
	//new VentanaPrincipal(controller);
	new LoginWindow(controller);
>>>>>>> 1bbcaec (update)
	
	
		

	}
}