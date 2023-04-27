package api.reservation;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import api.APIUtils;
import domain.Booking;
import domain.Guest;
import domain.Room;
import domain.User;
import main.Server;
import main.ServerAppService;

public class ReservationCreationHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange t) throws IOException {
		try {
			System.out.println("Creating reservation");
	    	JSONObject obj = new JSONObject(APIUtils.readBody(t));
	    	System.out.println(obj.toString());
	    	String token = APIUtils.getStringHeader(t, "token", "");
	    	if(token == "") {
	    		String resp = "No token provided";
	    		t.sendResponseHeaders(401, resp.length());
	    		OutputStream os = t.getResponseBody();
		 		os.write(resp.getBytes());
		 		os.close();
		 		return;
	    	}
	    	User author = Server.getUser(token);
	    	if(author == null) {
	    		String resp = "Invalid token";
	    		t.sendResponseHeaders(401, resp.length());
	    		OutputStream os = t.getResponseBody();
		 		os.write(resp.getBytes());
		 		os.close();
		 		return;
	    	}
	    	try {
	    		List<Guest> guests= new ArrayList<>();
	    		for (Object _o : obj.getJSONArray("guests")) {
	    			JSONObject o = (JSONObject)_o;
	    			guests.add(new Guest(o.getString("name"), o.getString("surname"), o.getString("dni"), o.getInt("age"), o.getString("cityOfProvenance")));
	    		}
	    		Calendar c = Calendar.getInstance();
	    		long checkinDate = obj.getLong("checkinDate");
	    		c.set(Calendar.DAY_OF_YEAR, (int)(checkinDate%365));
	    		c.set(Calendar.YEAR, (int)(checkinDate/365));
	    		Date inDate = c.getTime();
	    		long checkoutDate = obj.getLong("checkoutDate");
	    		c.set(Calendar.DAY_OF_YEAR, (int)(checkoutDate%365));
	    		c.set(Calendar.YEAR, (int)(checkoutDate/365));
	    		Date outDate = c.getTime();
	    		Booking b = Booking.fromJSON(obj);
	    		b.setAuthor(author.getLegalInfo());
	    		if(ServerAppService.reservationCreate(b)) {
	    			APIUtils.respondACK(t);
	    		}else {
	    			APIUtils.respondError(t, "The reservation couldn't be done");
	    		}
	      	}catch(IllegalArgumentException | JSONException e) {
	      		APIUtils.respondError(t, e.getMessage());
	    	}
		}catch(IOException e) {
			APIUtils.respondInternalError(t, e.getMessage());
		}
    	
    }

}
