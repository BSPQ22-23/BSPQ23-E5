package api.hotel;

import java.io.IOException;
import java.io.OutputStream;

import org.json.JSONException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import api.APIUtils;
import main.ServerAppService;

public class HotelGetterHandler implements HttpHandler{
	
	public void handle(HttpExchange exchange) throws IOException {
		String name = APIUtils.getStringHeader(exchange, "query", "");
    	try {
    		String body = null;
    		if(name == "")
    			body = APIUtils.listToJSONArray(ServerAppService.getHotels()).toString();
    		else
    			body = APIUtils.listToJSONArray(ServerAppService.getHotels(name)).toString();
			exchange.sendResponseHeaders(200, body.length());
    		OutputStream os = exchange.getResponseBody();
	 		os.write(body.getBytes());
	 		os.close();
    	} catch(IllegalArgumentException | JSONException e) {
    		APIUtils.respondError(exchange, e.getMessage());
		}catch(IOException e) {
			APIUtils.respondInternalError(exchange, e.getMessage());
		}
	}

}
