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
import api.reservation.*;
import database.UserDAO;
import domain.User;

public class Server {
	private static final HashMap<String, User> tokenList = new HashMap<>();
	public static void main(String[] args){
		UserDAO.getInstance();
		try {
	        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
	        server.createContext("/register", new RegisterHandler());
	        server.createContext("/login", new LoginHandler());
	        server.createContext("/booking/create", new ReservationCreationHandler());
	        server.createContext("/booking/get", new ReservationGetterHandler());
	        server.createContext("/booking/edit", new ReservationEditHandler());
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
	public static User getUser(String token) {
		return tokenList.get(token);
	}
	/**
	 * Creates a token for the user if it's not already logged
	 * @param user
	 * @return
	 */
	public static String createSession(User user) {
		if(user == null)
			return null;
		for(Entry<String, User> entry : tokenList.entrySet()) {
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
