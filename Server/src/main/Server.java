package main;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map.Entry;

import com.sun.net.httpserver.HttpServer;

import api.*;
import domain.Guest;

public class Server {
	private static final HashMap<String, Guest> tokenList = new HashMap<>();
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
	public static Guest getUser(String token) {
		return tokenList.get(token);
	}
	/**
	 * Creates a token for the user if it's not already logged
	 * @param user
	 * @return
	 */
	public static String createSession(Guest user) {
		if(user == null)
			return null;
		for(Entry<String, Guest> entry : tokenList.entrySet()) {
			if(entry.getValue().equals(user))
				return entry.getKey();
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update((""+Integer.toHexString(user.hashCode())).getBytes());
		    byte[] digest = md.digest();
		    String token = new String(Base64.getEncoder().encode(digest), StandardCharsets.UTF_8);
			tokenList.put(token, user);
			System.out.println("Session created " + token);
			return token;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("Invalid session");
			return null;
		}
	    
	}
}
