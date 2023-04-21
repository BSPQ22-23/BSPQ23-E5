package api;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import domain.PasswordEncryption;
import main.ServerAppService;

public class LoginHandler implements HttpHandler{

	@Override
    public void handle(HttpExchange t) throws IOException {
		System.out.println("Logging user");
		String body =APIUtils.readBody(t);
		JSONObject obj = new JSONObject(body);
		String token = null;
		try {
			token = ServerAppService.login(
				APIUtils.decode(obj.getString("user")),
				PasswordEncryption.encryptPassword(APIUtils.decode(obj.getString("password")))
			);
		}catch(IllegalArgumentException | JSONException e) {
    		String response = e.getMessage();
    		t.sendResponseHeaders(400, response.length());
    		OutputStream os = t.getResponseBody();
    		os.write(response.getBytes());
    		System.out.println('o');
    		os.close();
    	}
		System.out.println("Token generated " +token);
		if(token == null) {
			String res = "User or password incorrect";
			t.sendResponseHeaders(400, res.length());
			OutputStream os = t.getResponseBody();
			os.write(res.getBytes());
			os.close();
			return;
		}
		token = Base64.getEncoder().encodeToString(token.getBytes());
		System.out.println("token= " +token);
			t.sendResponseHeaders(200, token.length());
			OutputStream os = t.getResponseBody();
	 		os.write(token.getBytes());
	 		os.close();
    }

}
