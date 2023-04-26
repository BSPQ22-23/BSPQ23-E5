package domain;

public class Room {
	private int roomNumber;
    private String type;
    private int numMaxGuests;
    private int spaceInMeters;
    private float prize;

    public Room(int roomNumber, String type, int numMaxHosts, int spaceInMeters, float prize) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.numMaxGuests = numMaxHosts;
        this.spaceInMeters = spaceInMeters;
        this.prize = prize;
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

    public void setType(String type) {
        this.type = type;
    }
    public float getPrize() {
    	return prize;
    }
    public void setPrize(float prize) {
    	this.prize = prize;
    }
    public int getNumMaxGuests() {
        return numMaxGuests;
    }

    public void setNumMaxGuests(int numMaxHosts) {
        this.numMaxGuests = numMaxHosts;
    }

}
