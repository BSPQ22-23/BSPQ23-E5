package es.deusto.spq.server;

import java.util.ArrayList;

import java.util.List;

/**
 * Represents a hotel establishment.
 */
public class Hotel {

    private int id;
    private String name;
    private String city;
    private Guest owner;
    private List<Room> rooms;
    private List<Service> services;

    /**
     * Constructs a new Hotel object with the specified name, city, and owner.
     *
     * @param name  The name of the hotel.
     * @param city  The city where the hotel is located.
     * @param owner The owner of the hotel.
     */
    public Hotel(String name, String city, Guest owner) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.rooms = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    /**
     * Constructs a new Hotel object with the specified name.
     *
     * @param name The name of the hotel.
     */
    public Hotel(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the hotel.
     *
     * @return The ID of the hotel.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hotel.
     *
     * @param name The name of the hotel.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the city where the hotel is located.
     *
     * @return The city where the hotel is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the hotel is located.
     *
     * @param city The city where the hotel is located.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the list of rooms in the hotel.
     *
     * @return The list of rooms in the hotel.
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets the list of rooms in the hotel.
     *
     * @param rooms The list of rooms in the hotel.
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Adds a room to the hotel.
     *
     * @param room The room to add.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Removes a room from the hotel.
     *
     * @param room The room to remove.
     */
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    /**
     * Returns the list of services provided by the hotel.
     *
     * @return The list of services provided by the hotel.
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Sets the list of services provided by the hotel.
     *
     * @param services The list of services provided by the hotel.
     */
    public void setServices(List<Service> services) {
        this.services = services;
    }

    /**
     * Adds a service to the hotel.
     *
     * @param service The service to add.
     */
    public void addService(Service service) {
        services.add(service);
    }

    /**
     * Removes a service from the hotel.
     *
     * @param service The service to remove.
     */
    public void removeService(Service service) {
        services.remove(service);
    }

    /**
     * Returns the owner of the hotel.
     *
     * @return The owner of the hotel.
     */
    public Guest getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the hotel.
     *
     * @param owner The owner of the hotel.
     */
    public void setOwner(Guest owner) {
        this.owner = owner;
    }
}
