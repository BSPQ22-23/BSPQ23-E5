package domain;

import org.json.JSONObject;

import api.APIUtils;

public class Room {
	private int roomNumber;
    private String type;
    private int numMaxGuests;
    private int spaceInMeters;
    
    public static Room fromJSON(JSONObject object) {
    	return new Room(
    				object.getInt("roomNumber"), 
    				APIUtils.decode(object.getString("type")),
    				object.getInt("numMaxHosts"),
    				object.getInt("spaceInMeters")
    			);
    }
    public Room(int roomNumber, String type, int numMaxHosts, int spaceInMeters) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.numMaxGuests = numMaxHosts;
        this.spaceInMeters = spaceInMeters;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getSpaceInMeters() {
		return spaceInMeters;
	}

	public void setSpaceInMeters(int spaceInMeters) {
		this.spaceInMeters = spaceInMeters;
	}

	public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setTupe(String type) {
        this.type = type;
    }

    public int getNumMaxGuests() {
        return numMaxGuests;
    }

    public void setNumMaxGuests(int numMaxHosts) {
        this.numMaxGuests = numMaxHosts;
    }

}
