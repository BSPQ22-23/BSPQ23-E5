package domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String city;
    private List<Room> rooms;
    private List<Service> services;
    private List<Booking> bookings;

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
        this.rooms = new ArrayList<>();
        this.services = new ArrayList<>();
        this.bookings = new ArrayList<>();
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
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking guest) {
        bookings.add(guest);
    }

    public void removeBooking(Booking guest) {
        bookings.remove(guest);
    }
}

