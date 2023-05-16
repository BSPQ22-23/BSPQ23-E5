package com.domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.remote.APIUtils;

import domain.Room;
import domain.Service;

	public class Hotel {
		private int id;
	    private String name;
	    private String city;
	    private List<Room> rooms;
	    private List<Service> services;

    
    public Hotel(int id, String name, String city) {
    	this.id = id;
        this.name = name;
        this.city = city;
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

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }
    
}
