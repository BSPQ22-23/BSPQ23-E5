package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceTest {


    private Service service;
    private String name;
    private String description;
    private double price;

    @Before
    public void setUp() {
        name = "Room Cleaning";
        description = "Cleaning service for the room";
        price = 50.0;

        service = new Service(name, description, price);
    }

    @Test
    public void testGetName() {
        assertEquals(name, service.getName());
    }

    @Test
    public void testSetName() {
        String newName = "Room Service";
        service.setName(newName);
        assertEquals(newName, service.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals(description, service.getDescription());
    }

    @Test
    public void testSetDescription() {
        String newDescription = "In-room dining service";
        service.setDescription(newDescription);
        assertEquals(newDescription, service.getDescription());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, service.getPrice(), 0.01);
    }

    @Test
    public void testSetPrice() {
        double newPrice = 60.0;
        service.setPrice(newPrice);
        assertEquals(newPrice, service.getPrice(), 0.01);
    }

}
