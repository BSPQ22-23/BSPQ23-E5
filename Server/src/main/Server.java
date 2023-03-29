package main;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.sun.net.httpserver.HttpServer;

import api.*;

public class Server {
	private static final HashMap<String, Object> tokenList = new HashMap<String, Object>(); //TODO Change value type to User
	public static void main(String[] args){
		try {
	        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
	        server.createContext("/register", new RegisterHandler());
	        server.createContext("/login", new LoginHandler());
	        server.setExecutor(null); // creates a default executor
	        server.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	/**
	 * Returns the user that corresponds to the token input
	 * @param token Token of the account
	 * @return The account associated
	 */
	public static Object getUser(String token) {
		return tokenList.get(token);
	}
	/**
	 * Creates a token for the user if it's not already logged
	 * @param user
	 * @return
	 */
	public static String createSession(Object user) {
		for(Entry<String, Object> entry : tokenList.entrySet()) {
			if(entry.getValue().equals(user))
				return entry.getKey();
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update((""+Integer.toHexString(user.hashCode())).getBytes());
		    byte[] digest = md.digest();
		    String token = new String(digest, StandardCharsets.UTF_8);
			tokenList.put(token, user);
			return token;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	    
	}
}
