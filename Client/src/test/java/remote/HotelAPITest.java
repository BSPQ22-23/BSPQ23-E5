package remote;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

import domain.Guest;
import domain.Hotel;
import domain.Room;
import domain.User;
import remote.ClientController;
import remote.ServiceLocator;
import remote.ClientController.Response;

public class HotelAPITest {
	private ServiceLocator handler;
	
	@Before
	public void setup() throws IOException, InterruptedException, ExecutionException {
		handler = new ServiceLocator("localhost", 8000);
		ClientController.setServerHandler(handler);
		
		User hm = new User(
			"hotelManager", 
			"AnotherPassword", 
			true, 
			new Guest("Benjamin", "Dover", "305MWW", 29, "Miami, Florida")
		);
		if(ClientController.register(hm).status != Response.SUCCESS)
			ClientController.login(hm.getNick(), hm.getPassword());
	}
	
	@Test
	public void mainTest() throws InterruptedException, ExecutionException {
		Hotel h = new Hotel(
				0, 
				"Hotel Lakua", 
				"Vitoria"
		
		);
		h.addRoom(new Room(100, "Single", 1, 1, 1, null));
		Response creation = ClientController.createHotel(h);
		assertEquals(creation.status, Response.BAD_REQUEST);
		
		if(ClientController.register(
				new User(
					"OriginalNick", 
					"ASecurePassword",
					false,
					new Guest(
						"This is a name", 
						"This is a surname",  
						"123456789J", 
						10, 
						"A city somewhere" 
					)
				)
			).status != Response.SUCCESS)
			ClientController.login("OriginalNick", "ASecurePassword");
		
		Response unauthCreation = ClientController.createHotel(h);
		assertEquals(unauthCreation.status, Response.UNATHORIZED);
		System.out.println(unauthCreation.message);
		
		List<Hotel> getAll = ClientController.getHotels();
		assertNotEquals(0, getAll.size());
		System.out.println(getAll);
		
		Hotel[] getExisting = ClientController.getHotels("La");
		assertEquals(getExisting.length, 1);
		
		Hotel[] getNotExisting = ClientController.getHotels("▓");
		assertEquals(getNotExisting.length, 0);
	}
}
