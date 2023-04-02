package remote;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import domain.Guest;

public class ClientController {
	public static class Response {
		public final String message;
		public final int status;
		public Response(int status, String message) {
			this.message = message;
			this.status = status;
		}
		/**
		 * Responded when a query gets a response from the server
		 */
		public static final int SUCCESS = 200;
		/**
		 * One or many parameters are missing or have invalid values
		 */
		public static final int BAD_REQUEST = 400;
		/**
		 * The query requires a token and/or the token it's invalid
		 */
		public static final int UNATHORIZED = 401;
		/**
		 * The API doesn't have the method trying to reach or has been moved
		 */
		public static final int NOT_FOUND = 404;
	}
	public static void setServerHandler(ServiceLocator sv) {
		handler = sv;
	}
	@SuppressWarnings("unused")
	private static String token = null;
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		setServerHandler(new ServiceLocator("127.0.0.1", 8000));
		System.out.println(register(new Guest("name", "surname", "nick", "password", "dni", 1, "city", false)).message.length());
	}
	private static ServiceLocator handler;
	
	public static Response register(Guest g) throws InterruptedException, ExecutionException{
		try {
			HttpResponse<String> response = handler.sendRequest("register", APIUtils.objectToHeaders(g));
			if(response.statusCode() != 200)
				return new Response(response.statusCode(), response.body());
			else {
				token = response.body();
				return new Response(200, "");
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Response login(String user, String password) throws InterruptedException, ExecutionException {
		try {
			HashMap<String, String> headers = new HashMap<>();
			headers.put("user", user);
			headers.put("password", password);
			HttpResponse<String> response = handler.sendRequest("login", headers);
			if(response.statusCode() != 200)
				return new Response(response.statusCode(), response.body());
			else {
				token = response.body();
				return new Response(200, "");
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}
