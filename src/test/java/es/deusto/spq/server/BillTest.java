package es.deusto.spq.server;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.*;
public class BillTest {
	  private Bill bill;

	    @Before
	    public void setUp() {
	        int id = 1;
	        Date issueDate = new Date();
	        List<Service> services = new ArrayList<>();
	        double billTotal = 0.0;
	        Booking booking = new Booking(new Date(0), new Date(0), null, null, null);

	        bill = new Bill(id, issueDate, services, billTotal, booking);
	    }

	    @Test
	    public void testAddService() {
	        Service service = new Service("tele", "grande", 0);
	        bill.addService(service);
	        assertEquals(1, bill.getServices().size());
	        assertTrue(bill.getServices().contains(service));
	    }

	    @Test
	    public void testRemoveService() {
	        Service service1 = new Service("tele", "grande", 0);
	        Service service2 = new Service("tele", "pequeña", 0);
	        bill.addService(service1);
	        bill.addService(service2);

	        bill.removeService(service1);
	        assertEquals(1, bill.getServices().size());
	        assertFalse(bill.getServices().contains(service1));
	        assertTrue(bill.getServices().contains(service2));
	    }

	    @Test
	    public void testGettersAndSetters() {
	        int newId = 2;
	        Date newIssueDate = new Date();
	        List<Service> newServices = new ArrayList<>();
	        double newBillTotal = 100.0;
	        Booking newBooking = new Booking(new Date(0), new Date(0), null, null, null);

	        bill.setId(newId);
	        bill.setIssueDate(newIssueDate);
	        bill.setServices(newServices);
	        bill.setBillTotal(newBillTotal);
	        bill.setBooking(newBooking);

	        assertEquals(newId, bill.getId());
	        assertEquals(newIssueDate, bill.getIssueDate());
	        assertEquals(newServices, bill.getServices());
	        assertEquals(newBillTotal, bill.getBillTotal(), 0.0);
	        assertEquals(newBooking, bill.getBooking());
	    }

}
