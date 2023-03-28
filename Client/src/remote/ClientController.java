package remote;

import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ClientController {
	
	public static void setServerHandler(ServiceLocator sv) {
		handler = sv;
	}
	private static ServiceLocator handler;
	
	public static void register(String user, String password) throws InterruptedException, ExecutionException{
		try {
			HashMap<String, String> headers = new HashMap<>();
			headers.put("user", user);
			headers.put("password", password);
			HttpResponse<String> response = handler.sendRequest("register");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}