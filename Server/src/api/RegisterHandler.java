package api;

import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RegisterHandler implements HttpHandler{
	
    @Override
    public void handle(HttpExchange t) throws IOException {
    	t.getRequestHeaders().forEach((k, v) -> {
    		System.out.println(k + ':' + v);
    	});
//    	System.out.println(t.getRequestHeaders());
//        String response = "This is the response";
//        t.sendResponseHeaders(200, response.length());
//        OutputStream os = t.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
    }
}
