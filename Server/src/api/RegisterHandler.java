package api;

import java.io.IOException;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import main.ServerAppService;

public class RegisterHandler implements HttpHandler{
	
    @Override
    public void handle(HttpExchange t) throws IOException {
    	System.out.println(t.getAttribute("user"));
    	ServerAppService.register(t.getRequestHeaders().getOrDefault("user", List.of("")).get(0), t.getRequestHeaders().getOrDefault("password", List.of("")).get(0));
    	//TODO Generate token
//    	System.out.println(t.getRequestHeaders());
//        String response = "This is the response";
//        t.sendResponseHeaders(200, response.length());
//        OutputStream os = t.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
    }
}
