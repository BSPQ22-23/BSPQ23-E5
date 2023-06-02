package es.deusto.spq.server;


/**
 * Represents a guest staying at a hotel.
 */
public class Guest {
    private String dni;
    private String name;
    private String surname;
    private int age;
    private String cityOfProvenance;

    /**
     * Constructs a new Guest object with the specified parameters.
     *
     * @param name             The name of the guest.
     * @param surname          The surname of the guest.
     * @param dni              The identification number of the guest.
     * @param age              The age of the guest.
     * @param cityOfProvenance The city of provenance of the guest.
     */
    public Guest(String name, String surname, String dni, int age, String cityOfProvenance) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
        this.cityOfProvenance = cityOfProvenance;
    }

    /**
     * Returns the name of the guest.
     *
     * @return The name of the guest.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the guest.
     *
     * @param name The name of the guest.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the surname of the guest.
     *
     * @return The surname of the guest.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the guest.
     *
     * @param surname The surname of the guest.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the identification number of the guest.
     *
     * @return The identification number of the guest.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets the identification number of the guest.
     *
     * @param dni The identification number of the guest.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Returns the age of the guest.
     *
     * @return The age of the guest.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the guest.
     *
     * @param age The age of the guest.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the city of provenance of the guest.
     *
     * @return The city of provenance of the guest.
     */
    public String getCityOfProvenance() {
        return cityOfProvenance;
    }

    /**
     * Sets the city of provenance of the guest.
     *
     * @param cityOfProvenance The city of provenance of the guest.
     */
    public void setCityOfProvenance(String cityOfProvenance) {
        this.cityOfProvenance = cityOfProvenance;
    }

    /**
     * Compares this Guest object to the specified object.
     *
     * @param o The object to compare to.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Guest && ((Guest) o).dni.equals(dni);
    }

    /**
     * Returns a string representation of the Guest object.
     *
     * @return A string representation of the Guest object.
     */
    @Override
    public String toString() {
        return "Guest [name=" + name + ", surname=" + surname + ", dni="
                + dni + ", age=" + age + ", cityOfProvenance=" + cityOfProvenance
                + "]";
    }
}
