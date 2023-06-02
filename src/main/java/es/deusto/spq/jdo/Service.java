package es.deusto.spq.jdo;



import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * The Service class represents a service offered by a hotel.
 */
@PersistenceCapable(detachable = "true")
public class Service implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
    private String name;
    private String description;
    private double price;

    /**
     * Constructs a Service object with the given parameters.
     * 
     * @param name        the name of the service
     * @param description the description of the service
     * @param price       the price of the service
     */
    public Service(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Returns the name of the service.
     * 
     * @return the name of the service
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the service.
     * 
     * @param name the name of the service to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the service.
     * 
     * @return the description of the service
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the service.
     * 
     * @param description the description of the service to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the service.
     * 
     * @return the price of the service
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the service.
     * 
     * @param price the price of the service to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}