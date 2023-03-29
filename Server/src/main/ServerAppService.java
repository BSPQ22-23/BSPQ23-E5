package main;

public class ServerAppService {
	/**
	 * Checks if a username it's not already taken and adds it to the database if possible
	 *  @param username Username of the registering account
	 *  @param password Password of the registering account
	 * @param string 
	 *  @return The account token or null if the user can't be registered
	 */
	public static String register(String username, String email, String password) {
		
		return Server.createSession(username);//TODO Change username for the User class instance
	}
	/**
	 * Checks if a user can be logged in
	 * @param username Username of the logging account
	 * @param password Password of the logging account
	 * @return The account token or null if the user credentials aren't correct
	 */
	public static String login(String username, String password) {
		
		return Server.createSession(username);//TODO Change username for the User class instance
	}
}
