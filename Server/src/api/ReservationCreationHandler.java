package api;

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

import domain.Booking;
import domain.Guest;
import domain.User;
import main.Server;
import main.ServerAppService;

public class ReservationCreationHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange t) throws IOException {
		System.out.println("Creating reservation");
    	JSONObject obj = new JSONObject(APIUtils.readBody(t));
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
    			guests.add(new Guest(o.getString("name"), o.getString("surname"), o.getString("dni"), o.getInt("age"), o.getString("cityOfProvenance"), false));
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
    		if(ServerAppService.reservationCreate(author, new Booking(inDate, outDate, null, guests))) {
    			t.sendResponseHeaders(200, 3);
    			OutputStream os = t.getResponseBody();
    			os.write("ACK".getBytes());
    			os.close();
    		}else {
    			String response = "The reservation couldn't be done";
        		t.sendResponseHeaders(400, response.length());
        		OutputStream os = t.getResponseBody();
        		os.write(response.getBytes());
        		os.close();
    		}
      	}catch(IllegalArgumentException | JSONException e) {
    		String response = e.getMessage();
    		t.sendResponseHeaders(400, response.length());
    		OutputStream os = t.getResponseBody();
    		os.write(response.getBytes());
    		os.close();
    	}
    	
    }

}
