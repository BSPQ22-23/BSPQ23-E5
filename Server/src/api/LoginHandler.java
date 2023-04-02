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
		String token = Base64.getEncoder().encodeToString(ServerAppService.login(
			APIUtils.getStringHeader(t, "user", ""),
			APIUtils.getStringHeader(t, "password", "")
		).getBytes());
		String hashedPassword = PasswordEncryption.encryptPassword(APIUtils.getStringHeader(t, "password", ""));
		if(token != null) {
			t.sendResponseHeaders(200, token.length());
			OutputStream os = t.getResponseBody();
	 		os.write(token.getBytes());
	 		os.close();
		}else {
			t.sendResponseHeaders(400, 26);
			OutputStream os = t.getResponseBody();
			os.write("User or password incorrect".getBytes());
			os.close();
		}
    }

}
