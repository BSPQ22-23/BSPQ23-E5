package es.deusto.spq.server.domain;

import java.util.Date;
import java.util.List;

/**
 * Represents a bill in the hotel management system.
 */
public class Bill {
    private int id;
    private Date issueDate;
    private List<Service> services;
    private double billTotal;
    private Booking booking;

    /**
     * Constructs a Bill object with the specified details.
     *
     * @param id         The ID of the bill.
     * @param issueDate  The date the bill was issued.
     * @param services   The list of services included in the bill.
     * @param billTotal  The total amount of the bill.
     * @param booking    The booking associated with the bill.
     */
    public Bill(int id, Date issueDate, List<Service> services, double billTotal, Booking booking) {
        this.id = id;
        this.issueDate = issueDate;
        this.services = services;
        this.billTotal = billTotal;
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /**
     * Adds a service to the bill.
     *
     * @param service The service to add.
     */
    public void addService(Service service) {
        services.add(service);
    }

    /**
     * Removes a service from the bill.
     *
     * @param service The service to remove.
     */
    public void removeService(Service service) {
        services.remove(service);
    }
}
