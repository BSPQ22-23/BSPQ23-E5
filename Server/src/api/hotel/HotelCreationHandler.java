package api.hotel;

import java.io.IOException;
import java.io.OutputStream;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import api.APIUtils;
import domain.Hotel;
import domain.User;
import main.Server;
import main.ServerAppService;

public class HotelCreationHandler implements HttpHandler{

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
	    	if(author == null || !author.isHotelOwner()) {
	    		String resp = "Invalid token";
	    		exchange.sendResponseHeaders(401, resp.length());
	    		OutputStream os = exchange.getResponseBody();
		 		os.write(resp.getBytes());
		 		os.close();
		 		return;
	    	}
	    	Hotel h = Hotel.fromJSON(new JSONObject(APIUtils.readBody(exchange)));
	    	h.setOwner(author.getLegalInfo());
	    	if(ServerAppService.createHotel(h)) {
	    		APIUtils.respondACK(exchange);
	    	}else {
	    		APIUtils.respondError(exchange, "Something went wrong");
	    	}
		} catch(Exception e) {
			APIUtils.respondInternalError(exchange, e.getMessage());
		}
	}

}
