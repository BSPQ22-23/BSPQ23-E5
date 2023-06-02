package es.deusto.spq.server.domain;

import java.util.ArrayList;

import java.util.List;



/**
 * Represents a hotel in the hotel management system.
 */
public class Hotel {
    private int id;
    private String name;
    private String city;
    private Guest owner;
    private List<Room> rooms;
    private List<Service> services;

    /**
     * Constructs a Hotel object with the specified details.
     *
     * @param name    The name of the hotel.
     * @param city    The city where the hotel is located.
     * @param owner   The owner of the hotel.
     */
    public Hotel(String name, String city, Guest owner) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.rooms = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

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

    public List<Service> getServices() {
        return services;
    }

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

    public Guest getOwner() {
        return owner;
    }

    public void setOwner(Guest owner) {
        this.owner = owner;
    }
}
