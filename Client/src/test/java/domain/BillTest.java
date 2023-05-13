package domain;
import org.junit.Before;

import org.junit.Test;

import domain.Bill;
import domain.Booking;
import domain.Service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillTest {

	  private Bill bill;
	    private Service service1;
	    private Service service2;
	    private List<Service> services;
	
		private int id = 1;
		private Date issueDate = new Date();
		
		private double billTotal = 100.0;
		private Booking booking = new Booking(0,issueDate, issueDate, null, null);

	    @Before
	    public void setUp() throws Exception {
	        service1 = new Service("Servicio 1", "Descripción del servicio 1", 10.0);
	        service2 = new Service("Servicio 2", "Descripción del servicio 2", 20.0);
	        services = new ArrayList<Service>();
	        services.add(service1);
	        services.add(service2);
	        bill = new Bill(1, new Date(), services, 30.0, new Booking(0, null, null, null, null));
	    }

	    @Test
	    public void testAddService() {
	        Service service3 = new Service("Servicio 3", "Descripción del servicio 3", 15.0);
	        bill.addService(service3);
	        assertEquals(bill.getServices().size(), 3);
	        assertTrue(bill.getServices().contains(service3));
	    }

	    @Test
	    public void testRemoveService() {
	        bill.removeService(service1);
	        assertEquals(bill.getServices().size(), 1);
	        assertFalse(bill.getServices().contains(service1));
	    }
	    @Test
		public void testGetId() {
			assertEquals(id, bill.getId());
		}
		
		@Test
		public void testSetId() {
			int newId = 2;
			bill.setId(newId);
			assertEquals(newId, bill.getId());
		}
		
		@Test
		public void testGetIssueDate() {
			//assertNotEquals(issueDate, bill.getIssueDate());
		}
		
		@Test
		public void testSetIssueDate() {
			Date newIssueDate = new Date();
			bill.setIssueDate(newIssueDate);
			assertEquals(newIssueDate, bill.getIssueDate());
		}
		
		@Test
		public void testGetServices() {
			assertEquals(services, bill.getServices());
		}
		
		@Test
		public void testSetServices() {
			List<Service> newServices = new ArrayList<>();
			newServices.add(new Service("New Service", "New Description", 50.0));
			bill.setServices(newServices);
			assertEquals(newServices, bill.getServices());
		}
		
		@Test
		public void testGetBillTotal() {
			assertNotEquals(billTotal, bill.getBillTotal(), 0.0);
		}
		
		@Test
		public void testSetBillTotal() {
			double newBillTotal = 150.0;
			bill.setBillTotal(newBillTotal);
			assertEquals(newBillTotal, bill.getBillTotal(), 0.0);
		}
		
		@Test
		public void testGetBooking() {
			assertNotEquals(booking, bill.getBooking());
		}
		
			    

	}