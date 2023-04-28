package domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import api.APIUtils;

public class Hotel {
	private int id;
    private String name;
    private String city;
    private Guest owner;
    private List<Room> rooms;
    private List<Service> services;

    public static Hotel fromJSON(JSONObject obj) {
    	Hotel result = new Hotel(
    			APIUtils.decode(obj.getString("name")),
    			APIUtils.decode(obj.getString("city")),
    			obj.keySet().contains("owner")?Guest.fromJSON(obj.getJSONObject("owner")):null
    		);
    	if(obj.keySet().contains("rooms"))
    		for(Object o : obj.getJSONArray("rooms"))    result.addRoom(Room.fromJSON((JSONObject)o));
    	if(obj.keySet().contains("services"))
    		for(Object o : obj.getJSONArray("services")) result.addService(Service.fromJSON((JSONObject)o));
    	return result;
    }

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
    
    public Guest getOwner() {
		return owner;
	}

	public void setOwner(Guest owner) {
		this.owner = owner;
	}
}

