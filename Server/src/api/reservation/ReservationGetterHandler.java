package api.reservation;

import java.io.IOException;
import java.io.OutputStream;

import org.json.JSONException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import api.APIUtils;
import domain.Booking;
import domain.User;
import main.Server;
import main.ServerAppService;

public class ReservationGetterHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String token = APIUtils.getStringHeader(exchange, "token", "");
		if(token == "") {
			String resp = "No token provided";
    		exchange.sendResponseHeaders(401, resp.length());
    		OutputStream os = exchange.getResponseBody();
	 		os.write(resp.getBytes());
	 		os.close();
	 		return;
		}
		User author = Server.getUser(token);
    	if(author == null) {
    		String resp = "Invalid token";
    		exchange.sendResponseHeaders(401, resp.length());
    		OutputStream os = exchange.getResponseBody();
	 		os.write(resp.getBytes());
	 		os.close();
	 		return;
    	}
    	try {
	    	String queryType = APIUtils.getStringHeader(exchange, "queryType", "user");
	    	String parameter = APIUtils.getStringHeader(exchange, "value", "");
	    	switch (queryType) {
			case "user":
				String body = APIUtils.listToJSONArray(ServerAppService.getReservationsByUser(author)).toString();
				exchange.sendResponseHeaders(200, body.length());
	    		OutputStream os = exchange.getResponseBody();
		 		os.write(body.getBytes());
		 		os.close();
		 		return;
			case "hotel":
				body = APIUtils.listToJSONArray(ServerAppService.getReservationsByHotel(parameter)).toString();
				exchange.sendResponseHeaders(200, body.length());
	    		os = exchange.getResponseBody();
		 		os.write(body.getBytes());
		 		os.close();
				return;
			case "single":
				Booking res = ServerAppService.getReservationById(parameter);
				if(res == null) {
					String response = "Not Found";
		    		exchange.sendResponseHeaders(404, response.length());
		    		os = exchange.getResponseBody();
		    		os.write(response.getBytes());
		    		os.close();
				} else {
					body = APIUtils.objectToJSON(res).toString();
					exchange.sendResponseHeaders(200, body.length());
		    		os = exchange.getResponseBody();
			 		os.write(body.getBytes());
			 		os.close();
				}
				return;
			default:
				String response = "No method called '"+queryType+'\'';
	    		exchange.sendResponseHeaders(400, response.length());
	    		os = exchange.getResponseBody();
	    		os.write(response.getBytes());
	    		os.close();
				return;
			}
    	} catch(IllegalArgumentException | JSONException e) {
    		String response = e.getMessage();
    		exchange.sendResponseHeaders(400, response.length());
    		OutputStream os = exchange.getResponseBody();
    		os.write(response.getBytes());
    		os.close();
    	}
	}

}
