package api;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import domain.Guest;
import domain.PasswordEncryption;
import main.ServerAppService;

public class RegisterHandler implements HttpHandler{
	
    @Override
    public void handle(HttpExchange t) throws IOException {
    	try {
    		String token = Base64.getEncoder().encodeToString(
    			ServerAppService.register(
    				new Guest(
    				APIUtils.getStringHeader(t, "name", ""),
    				APIUtils.getStringHeader(t, "surname", ""),
    				APIUtils.getStringHeader(t, "nick", ""),
					APIUtils.getStringHeader(t, "password", ""),
					APIUtils.getStringHeader(t, "dni", ""),
					Integer.parseInt(t.getRequestHeaders().getOrDefault("age", List.of("0")).get(0)),
    				APIUtils.getStringHeader(t, "cityOfProvenance", ""),
    				APIUtils.getStringHeader(t, "isHoterOwner", "").equals("true")
    		)).getBytes());
    		String hashedPassword = PasswordEncryption.encryptPassword(APIUtils.getStringHeader(t, "password", ""));

    		if(token != null) {
    			t.sendResponseHeaders(200, token.length());
    			OutputStream os = t.getResponseBody();
   		 		os.write(token.getBytes());
   		 		os.close();
    		}else
    			throw new IllegalArgumentException("Unknown error occurred");
    	}catch(IllegalArgumentException e) {
    		String response = Base64.getEncoder().encodeToString(e.getMessage().getBytes());
    		t.sendResponseHeaders(400, response.length());
    		OutputStream os = t.getResponseBody();
    		os.write(response.getBytes());
    		os.close();
    	}
    	t.sendResponseHeaders(400, 26);
		OutputStream os = t.getResponseBody();
		os.write("User or password incorrect".getBytes());
		os.close();
    }
}
