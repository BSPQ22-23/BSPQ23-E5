package es.deusto.spq.server;


/**
 * Represents a service offered by a hotel.
 */
public class Service {

    private String name;
    private String description;
    private double price;

    /**
     * Constructs a new Service object with the specified name, description, and price.
     *
     * @param name        The name of the service.
     * @param description The description of the service.
     * @param price       The price of the service.
     */
    public Service(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Returns the name of the service.
     *
     * @return The name of the service.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the service.
     *
     * @param name The name of the service.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the service.
     *
     * @return The description of the service.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the service.
     *
     * @param description The description of the service.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the service.
     *
     * @return The price of the service.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the service.
     *
     * @param price The price of the service.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
