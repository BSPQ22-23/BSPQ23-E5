package api.reservation;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import api.APIUtils;
import domain.Booking;
import domain.User;
import main.Server;
import main.ServerAppService;

public class ReservationEditHandler implements HttpHandler{

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		try {
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
			switch (exchange.getRequestMethod()) {
				case "DELETE":
					System.out.println("Deleting reservation");
					int id = Integer.parseInt(exchange.getRequestHeaders().getOrDefault("id", List.of("-1")).get(0));
					System.out.println(id);
					if(id < 0) {
						String response = "Invalid / Missing id";
			    		exchange.sendResponseHeaders(400, response.length());
			    		OutputStream os = exchange.getResponseBody();
			    		os.write(response.getBytes());
			    		os.close();
						return;
					}
					ServerAppService.deleteReservation(author, id);
					return;
				case "POST":
					System.out.println("Editing reservation");
					System.out.println(APIUtils.readBody(exchange));
					ServerAppService.editReservation(author, Booking.fromJSON(new JSONObject(APIUtils.readBody(exchange))));
					return;
				default:
					String response = "Method "+exchange.getRequestMethod()+" not valid for this function";
		    		exchange.sendResponseHeaders(405, response.length());
		    		OutputStream os = exchange.getResponseBody();
		    		os.write(response.getBytes());
		    		os.close();
					return;
			}
		}catch(IOException e) {
			APIUtils.respondInternalError(exchange, e.getMessage());
		}
	}

}
