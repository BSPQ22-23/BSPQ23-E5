package domain;

import java.util.Date;
import java.util.List;

import domain.Booking;
import domain.Service;

public class Bill {
	private int id;
	private Date issueDate;
	private List<Service> services;
	private double billTotal;
	private Booking booking;

	/**
	 * 
	 * @param id
	 * @param issueDate
	 * @param services
	 * @param billTotal
	 * @param booking
	 */
	public Bill(int id, Date issueDate, List<Service> services, double billTotal, Booking booking) {
		this.id = id;
		this.issueDate = issueDate;
		this.services = services;
		this.billTotal = billTotal;
		this.booking = booking;
	}

	/**
	 * GET ID
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get issue date
	 * 
	 * @return date
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Set date
	 * 
	 * @param issueDate
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * get the list of services
	 * 
	 * @return list
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * set tthe list of services
	 * 
	 * @param services
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * get the total bill
	 * 
	 * @return bill
	 */
	public double getBillTotal() {
		return billTotal;
	}

	/**
	 * set the total bill
	 * 
	 * @param billTotal
	 */
	public void setBillTotal(double billTotal) {
		this.billTotal = billTotal;
	}

	/**
	 * Get the booking from the booking class
	 * 
	 * @return booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * Modificate the booking
	 * 
	 * @param booking
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * Creace a service
	 * 
	 * @param service
	 */
	public void addService(Service service) {
		services.add(service);
	}

	/**
	 * Delete a service
	 * 
	 * @param service
	 */
	public void removeService(Service service) {
		services.remove(service);
	}

}
