package es.deusto.spq.server.domain;


/**
 * Represents a service offered by a hotel.
 */
public class Service {
    private String name;
    private String description;
    private double price;

    /**
     * Constructs a Service object with the specified details.
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
