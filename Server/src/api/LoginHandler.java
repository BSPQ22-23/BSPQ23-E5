package api;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class LoginHandler  implements HttpHandler{

private String message;
	
	
	@Override
    public void handle(HttpExchange t) throws IOException {
		String response = message;
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();

		 
    }

}
