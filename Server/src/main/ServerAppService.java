package main;

import database.GuestDAO;
import domain.Guest;

public class ServerAppService {
	/**
	 * Checks if a username it's not already taken and adds it to the database if possible
	 *  @param username Username of the registering account
	 *  @param password Password of the registering account
	 * @param string 
	 *  @return The account token
	 *  @throws IllegalArgumentException if there's a missing argument or an illegal value is sent
	 */
	public static String register(Guest user) {
		System.out.println("Register user: " +user.toString());
		if(user.getAge() == 0 || user.getCityOfProvenance() == "" || user.getDni() == "" || user.getName() == "" || user.getNick() == "" || user.getPassword() == "" || user.getSurname() == "") {
			System.out.println("Invalid field");
			throw new IllegalArgumentException("You must fill all fields");
		}else {
			if(GuestDAO.getInstance().exists(user.getNick()))
				throw new IllegalArgumentException("User already exists");
			System.out.println("Registration authorized");
			GuestDAO.getInstance().save(user);
			return Server.createSession(user);//TODO Change username for the User class instance
		}
	}
	/**
	 * Checks if a user can be logged in
	 * @param username Username of the logging account
	 * @param password Password of the logging account
	 * @return The account token or null if the user credentials aren't correct
	 */
	public static String login(String username, String password) {
		System.out.println("Login user: username= " +username+ " password= " +password);
		return Server.createSession(GuestDAO.getInstance().find(username, password));//TODO Create the token if the user it's succesfully logged in
	}
}
