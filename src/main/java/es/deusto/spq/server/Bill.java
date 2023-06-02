package es.deusto.spq.server;

import java.util.Date;
import java.util.List;

/**
 * The Bill class represents a bill in the system.
 */
public class Bill {
    private int id;
    private Date issueDate;
    private List<Service> services;
    private double billTotal;
    private Booking booking;

    /**
     * Constructs a Bill object with the specified attributes.
     *
     * @param id         the ID of the bill
     * @param issueDate  the date the bill was issued
     * @param services   the list of services included in the bill
     * @param billTotal  the total amount of the bill
     * @param booking    the booking associated with the bill
     */
    public Bill(int id, Date issueDate, List<Service> services, double billTotal, Booking booking) {
        this.id = id;
        this.issueDate = issueDate;
        this.services = services;
        this.billTotal = billTotal;
        this.booking = booking;
    }

    /**
     * Returns the ID of the bill.
     *
     * @return the ID of the bill
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the bill.
     *
     * @param id the ID of the bill
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the date the bill was issued.
     *
     * @return the date the bill was issued
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the date the bill was issued.
     *
     * @param issueDate the date the bill was issued
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * Returns the list of services included in the bill.
     *
     * @return the list of services included in the bill
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Sets the list of services included in the bill.
     *
     * @param services the list of services included in the bill
     */
    public void setServices(List<Service> services) {
        this.services = services;
    }

    /**
     * Returns the total amount of the bill.
     *
     * @return the total amount of the bill
     */
    public double getBillTotal() {
        return billTotal;
    }

    /**
     * Sets the total amount of the bill.
     *
     * @param billTotal the total amount of the bill
     */
    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }

    /**
     * Returns the booking associated with the bill.
     *
     * @return the booking associated with the bill
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * Sets the booking associated with the bill.
     *
     * @param booking the booking associated with the bill
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /**
     * Adds a service to the list of services included in the bill.
     *
     * @param service the service to add
     */
    public void addService(Service service) {
        services.add(service);
    }

    /**
     * Removes a service from the list of services included in the bill.
     *
     * @param service the service to remove
     */
    public void removeService(Service service) {
        services.remove(service);
    }
}