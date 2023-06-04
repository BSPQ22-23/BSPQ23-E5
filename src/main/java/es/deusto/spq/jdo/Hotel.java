package es.deusto.spq.jdo;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * The Hotel class represents a hotel.
 */
@PersistenceCapable(detachable = "true")
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private int id;
	private String name;
	private String city;
	
	
	
	

	/**
	 * Creates a new instance of Hotel.
	 * 
	 * @param name  the hotel's name
	 * @param city  the hotel's city
	 * @param owner the hotel's owner
	 */
	public Hotel(String name, String city) {
		this.name = name;
		this.city = city;
		
	
	
	}

	/**
	 * Creates a new instance of Hotel with only the name.
	 * 
	 * @param name the hotel's name
	 */
	public Hotel(String name) {
		this.name = name;
	}

	/**
	 * Returns the hotel's ID.
	 * 
	 * @return the hotel's ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the hotel's name.
	 * 
	 * @return the hotel's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the hotel's name.
	 * 
	 * @param name the hotel's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the hotel's city.
	 * 
	 * @return the hotel's city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the hotel's city.
	 * 
	 * @param city the hotel's city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	

	

	

	
}
