package api.reservation;

import java.io.IOException;
import java.io.OutputStream;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import api.APIUtils;
import domain.User;
import main.Server;

public class ReservationEditHandler implements HttpHandler{

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
		JSONObject obj = new JSONObject(APIUtils.readBody(exchange));
		switch (exchange.getRequestMethod()) {
		case "DELETE":
			
			return;
		case "POST":
			
			return;
		default:
			String response = "Method "+exchange.getRequestMethod()+" not supported for this function";
    		exchange.sendResponseHeaders(400, response.length());
    		OutputStream os = exchange.getResponseBody();
    		os.write(response.getBytes());
    		os.close();
			return;
		}
	}

}
