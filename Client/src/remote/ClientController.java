package remote;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ClientController {
	public static void setServerHandler(ServiceLocator sv) {
		handler = sv;
	}
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		setServerHandler(new ServiceLocator("127.0.0.1", 8000));
		register("this is a user", "this is a password");
	}
	private static ServiceLocator handler;
	
	public static void register(String user, String password) throws InterruptedException, ExecutionException{
		try {
			HashMap<String, String> headers = new HashMap<>();
			headers.put("user", user);
			headers.put("password", password);
			HttpResponse<String> response = handler.sendRequest("register", headers);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public static void login(String user, String password) throws InterruptedException, ExecutionException {
		try {
			HashMap<String, String> headers = new HashMap<>();
			headers.put("user", user);
			headers.put("password", password);
			HttpResponse<String> response = handler.sendRequest("login", headers);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
