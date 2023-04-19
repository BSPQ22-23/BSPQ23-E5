package api;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import domain.Guest;
import domain.PasswordEncryption;
import main.ServerAppService;

public class RegisterHandler implements HttpHandler{
	
    @Override
    public void handle(HttpExchange t) throws IOException {
    	System.out.println("Registering user");
    	JSONObject obj = new JSONObject(APIUtils.readBody(t));
    	try {
    		String token = Base64.getEncoder().encodeToString(
    			ServerAppService.register(
    				new Guest(
    				APIUtils.decode(obj.getString("name")),
    				APIUtils.decode(obj.getString("surname")),
    				APIUtils.decode(obj.getString("nick")),
    				PasswordEncryption.encryptPassword(APIUtils.decode(obj.getString("password"))),
    				APIUtils.decode(obj.getString("dni")),
					obj.getInt("age"),
					APIUtils.decode(obj.getString("cityOfProvenance")),
    				obj.getBoolean("isHotelOwner")
    		)).getBytes());
    		if(token != null) {
    			t.sendResponseHeaders(200, token.length());
    			OutputStream os = t.getResponseBody();
   		 		os.write(token.getBytes());
   		 		os.close();
    		}else
    			throw new IllegalArgumentException("Unknown error occurred");
    	}catch(IllegalArgumentException | JSONException e) {
    		String response = e.getMessage();
    		t.sendResponseHeaders(400, response.length());
    		OutputStream os = t.getResponseBody();
    		os.write(response.getBytes());
    		System.out.println('o');
    		os.close();
    	}
    	t.sendResponseHeaders(400, 26);
		OutputStream os = t.getResponseBody();
		os.write("User or password incorrect".getBytes());
		os.close();
    }
}
