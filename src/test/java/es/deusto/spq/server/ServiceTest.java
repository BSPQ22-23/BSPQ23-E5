package es.deusto.spq.server;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.*;

public class ServiceTest {
	private Service service;

    @Before
    public void setUp() {
        service = new Service("Room Service", "In-room dining service", 25.99);
    }

    @Test
    public void testGetName() {
        assertEquals("Room Service", service.getName());
    }

    @Test
    public void testSetName() {
        service.setName("Spa Service");
        assertEquals("Spa Service", service.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("In-room dining service", service.getDescription());
    }

    @Test
    public void testSetDescription() {
        service.setDescription("Massage Service");
        assertEquals("Massage Service", service.getDescription());
    }

    @Test
    public void testGetPrice() {
        assertEquals(25.99, service.getPrice(), 0.01);
    }

    @Test
    public void testSetPrice() {
        service.setPrice(19.99);
        assertEquals(19.99, service.getPrice(), 0.01);
    }

}
