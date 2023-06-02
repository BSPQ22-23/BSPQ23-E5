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
	private Guest owner;
	private List<Room> rooms;
	private List<Service> services;

	/**
	 * Creates a new instance of Hotel.
	 * 
	 * @param name  the hotel's name
	 * @param city  the hotel's city
	 * @param owner the hotel's owner
	 */
	public Hotel(String name, String city, Guest owner) {
		this.name = name;
		this.city = city;
		this.owner = owner;
		this.rooms = new ArrayList<>();
		this.services = new ArrayList<>();
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

	/**
	 * Returns the list of rooms in the hotel.
	 * 
	 * @return the list of rooms
	 */
	public List<Room> getRooms() {
		return rooms;
	}

	/**
	 * Sets the list of rooms in the hotel.
	 * 
	 * @param rooms the list of rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * Adds a room to the hotel.
	 * 
	 * @param room the room to add
	 */
	public void addRoom(Room room) {
		rooms.add(room);
	}

	/**
	 * Removes a room from the hotel.
	 * 
	 * @param room the room to remove
	 */
	public void removeRoom(Room room) {
		rooms.remove(room);
	}

	/**
	 * Returns the list of services provided by the hotel.
	 * 
	 * @return the list of services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * Sets the list of services provided by the hotel.
	 * 
	 * @param services the list of services to set
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * Adds a service to the hotel.
	 * 
	 * @param service the service to add
	 */
	public void addService(Service service) {
		services.add(service);
	}

	/**
	 * Removes a service from the hotel.
	 * 
	 * @param service the service to remove
	 */
	public void removeService(Service service) {
		services.remove(service);
	}

	/**
	 * Returns the hotel's owner.
	 * 
	 * @return the hotel's owner
	 */
	public Guest getOwner() {
		return owner;
	}

	/**
	 * Sets the hotel's owner.
	 * 
	 * @param owner the hotel's owner to set
	 */
	public void setOwner(Guest owner) {
		this.owner = owner;
	}
}
