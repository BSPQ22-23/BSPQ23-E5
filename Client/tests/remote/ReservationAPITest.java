package remote;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import domain.Booking;
import domain.Guest;
import domain.Hotel;
import domain.Room;
import domain.User;
import remote.ClientController.Response;

public class ReservationAPITest {
	
	@Before
	public void setup() throws IOException, InterruptedException, ExecutionException {
		ClientController.setServerHandler(new ServiceLocator("localhost", 8000));
		if(ClientController.register(
				new User(
					"OriginalNick", 
					"ASecurePassword",
					new Guest(
						"This is a name", 
						"This is a surname",  
						"123456789J", 
						10, 
						"A city somewhere" 
					),
					false
				)
			).status != Response.SUCCESS)
			ClientController.login("OriginalNick", "ASecurePassword");
	}
	@Test
	public void testReservation() {
		Booking b = new Booking(
			2, 
			new Date(System.currentTimeMillis()), 
			new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)), 
			new Room(1, "Double", 2, 10, 15.5f, new Hotel("Name", "City")), 
			List.of(
				new Guest("Erik", "Torsten", "12314", 38, "Estocolmo"),
				new Guest("Tayane", "Alves", "987654321", 27, "Salvador")
			)
		);
		ClientController.createReservation(b);
		b.setCheckinDate(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)));
		System.out.println("Modify");
		ClientController.editReservation(b);
		System.out.println("Delete");
		ClientController.deleteReservation(b);
	}
}
