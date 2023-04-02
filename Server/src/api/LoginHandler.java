package api;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import domain.PasswordEncryption;
import main.ServerAppService;

public class LoginHandler  implements HttpHandler{

	@Override
    public void handle(HttpExchange t) throws IOException {
		System.out.println("Login reached");
		String token = ServerAppService.login(
				APIUtils.getStringHeader(t, "user", ""),
				PasswordEncryption.encryptPassword(APIUtils.getStringHeader(t, "password", ""))
			);
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
